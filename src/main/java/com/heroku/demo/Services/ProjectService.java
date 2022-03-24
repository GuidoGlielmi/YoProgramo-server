package com.heroku.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ProjectDto;
import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.Entities.ProjectUrl;
import com.heroku.demo.Repositories.ProjectRepo;
import com.heroku.demo.Repositories.ProjectUrlRepo;
import com.heroku.demo.Repositories.TechRepo;
import com.heroku.demo.ServicesInterfaces.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
  public Projects addProject(ProjectDto projectDto) {
    /* Since Technologies is ignoring the project property, it's necessary to use a DTO,
    because there is an inconsistency between a project that holds a tech and the same tech not holding said project */
    Projects newProject = projectDto.getProject();
    projectRepo.save(newProject); // CascadeType.PERSIST is not useful since it doesn't link the url to the project, so accessing urlRepo would be necessary anyways.
    for (ProjectUrl newUrl : newProject.getUrls()) {
      newUrl.setProject(newProject); // automatically constructs the project with the added url in the urls list, but not saves it ofc.
      // projectRepo.save(newProject); // can't persist an url without an id, so it saves an empty one
      urlRepo.save(newUrl); // this saves both the project and the url entries
    }
    return newProject;
  }

  @Override
  public Projects updateProject(ProjectDto projectDto) {
    Projects foundProject = projectRepo.findById(projectDto.getProject().getId()).orElseThrow();
    Projects updatedProject = projectDto.getProject();

    if (projectDto.getTechsIds() != null) {
      List<Technologies> newTechs = new ArrayList<>();
      for (UUID techId : projectDto.getTechsIds()) {
        Technologies tech = techRepo.findById(techId).orElseThrow();
        newTechs.add(tech);
      }
      foundProject.setTechs(newTechs);
    }

    if (updatedProject.getUrls() != null) {
      // project is not the owner, so it's necessary to delete via urlRepo
      for (ProjectUrl url : foundProject.getUrls()) {
        urlRepo.deleteById(url.getId());
      }
      for (ProjectUrl url : updatedProject.getUrls()) {
        urlRepo.save(url);
      }
      // foundProject.setUrls(updatedProject.getUrls());
    }
    if (!updatedProject.getTitle().isBlank()) {
      foundProject.setTitle(updatedProject.getTitle());
    }
    if (!updatedProject.getTitle().isBlank()) {
      foundProject.setTitle(updatedProject.getTitle());
    }
    if (!updatedProject.getDescription().isBlank()) {
      foundProject.setDescription(updatedProject.getDescription());
    }
    return foundProject;
  }

  @Override
  public List<Projects> deleteProject(UUID projectId) {
    projectRepo.findById(projectId).orElseThrow();
    projectRepo.deleteById(projectId);// without CascadeType.REMOVE it's not possible to delete the project, since it's the child in the relation.
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