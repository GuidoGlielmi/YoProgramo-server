package com.heroku.demo.Services;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.Entities.ProjectUrl;
import com.heroku.demo.Repositories.ProjectRepo;
import com.heroku.demo.Repositories.ProjectUrlRepo;
import com.heroku.demo.Repositories.TechRepo;
import com.heroku.demo.ServicesInterfaces.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectService implements IProjectService {

  @Autowired
  ProjectRepo projectRepo;
  @Autowired
  TechRepo techRepo;
  @Autowired
  ProjectUrlRepo urlRepo;

  ///////////////////////////////
  // PROJECTS
  //////////////////////////////

  @Override
  public List<Projects> getProjects() {
    return projectRepo.findAllByOrderByTitleAsc();
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Projects addProject(Projects newProject) {
    /*
    the project property of technologies is ignored
    but probably, because the project entity is the owner, by modifying and/or
    persisting its techs' list, the pertinent technologies are updated as well,
    being that they already have an id.
    */
    // Projects updatedProject = projectDto.getProject();
    /* for (UUID techId : projectDto.getTechsIds()) {
      Technologies tech = techRepo.findById(techId).orElseThrow();
      updatedProject.addTech(tech);
    } */
    projectRepo.save(newProject);
    /* CascadeType.PERSIST is not useful since it doesn't link the url to the project, so accessing urlRepo would be necessary anyways.
    It saves the urls like
    {
    id:'',
    url:'...',
    name:'...',
    project:null
    }
    */
    for (ProjectUrl newUrl : newProject.getUrls()) {
      newUrl.setProject(newProject); // automatically constructs the project with the added url in the urls list, but not saves it ofc.
      // projectRepo.save(updatedProject); // can't persist an url without an id, so it would save an empty one
      urlRepo.save(newUrl); // this saves both the project and the url entries
    }
    return newProject;
  }

  @Override
  public Projects updateProject(Projects updatedProject) {
    Projects foundProject = projectRepo.findById(updatedProject.getId()).orElseThrow();
    foundProject = updatedProject;
    /*
    the project property of technologies is ignored
    but probably, because the project entity is the owner, by modifying and/or
    persisting its techs' list, the pertinent technologies are updated as well,
    being that they already have an id.
    */
    if (updatedProject.getUrls() != null) {
      for (ProjectUrl url : updatedProject.getUrls()) {
        url.setProject(foundProject);//this automatically (without persisting it) adds the url to the project's list
        urlRepo.save(url); //  By being the owner, without persisting the url, the url entry doesn't get created, so it neither gets saved in the project
      }
    }
    return projectRepo.save(foundProject);
  }

  @Override
  public List<Projects> deleteProject(UUID projectId) {
    Projects foundProject = projectRepo.findById(projectId).orElseThrow();
    projectRepo.delete(foundProject);// without CascadeType.REMOVE it's not possible to delete the project, since it's the child in the relation.
    return projectRepo.findAllByOrderByTitleAsc();
  }

  ///////////////////////////////
  // TECHNOLOGIES
  //////////////////////////////
  @Override
  public List<Technologies> addTechToProject(UUID projectId, UUID techId) {
    Projects foundProject = projectRepo.findById(projectId).orElseThrow();
    Technologies foundTech = techRepo.findById(techId).orElseThrow();
    foundProject.addTech(foundTech);
    return projectRepo.save(foundProject).getTechs();
  }

  @Override
  public List<Technologies> removeTechFromProject(UUID projectId, UUID techId) {
    Projects persistedProject = projectRepo.findById(projectId).orElseThrow();
    Technologies persistedTech = techRepo.findById(techId).orElseThrow();
    persistedProject.getTechs().remove(persistedTech);
    return projectRepo.save(persistedProject).getTechs();
  }

  ///////////////////////////////
  // URLS
  ///////////////////////////////

  @Override
  public List<ProjectUrl> getUrls() {
    return urlRepo.findAllByOrderByProjectAscUrlAsc();
  }

  @Override
  public UUID addUrl(ProjectUrl newUrl) {
    Projects foundProject = projectRepo.findById(newUrl.getProjectId()).orElseThrow();
    newUrl.setProject(foundProject); //this automatically (without persisting it) adds the url to the project's list
    urlRepo.save(newUrl);
    return newUrl.getId();
  }

  @Override
  public ProjectUrl updateUrl(ProjectUrl url) {
    ProjectUrl oldUrl = urlRepo.findById(url.getId()).orElseThrow();
    if (url.getUrl() != null || !url.getUrl().isBlank()) {
      oldUrl.setUrl(url.getUrl());
    }
    if (url.getProjectId() != null) {
      Projects foundProject = projectRepo.findById(url.getProjectId()).orElseThrow();
      oldUrl.setProject(foundProject); //this automatically updates the url the the project's list
    }
    return urlRepo.save(oldUrl);
  }

  @Override
  public List<ProjectUrl> deleteUrl(UUID id) {
    ProjectUrl foundUrl = urlRepo.findById(id).orElseThrow();
    Projects urlProject = foundUrl.getProject();
    urlRepo.delete(foundUrl);
    return urlProject.getUrls();
  }
}