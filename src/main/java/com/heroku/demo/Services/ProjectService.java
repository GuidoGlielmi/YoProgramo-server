package com.heroku.demo.Services;

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

  @Override
  public List<Projects> getProjects() {
    return projectRepo.findAll();
  }

  @Override
  public Projects addProject(ProjectDto projectDto) {
    Projects newProject = projectDto.getProject();
    for (UUID techId : projectDto.getTechsIds()) {
      Technologies tech = techRepo.findById(techId).orElseThrow();
      newProject.addTech(tech);
    }
    projectRepo.save(newProject); // With this, the urls are persisted AND, as such, saved in newProject
    for (ProjectUrl newUrl : newProject.getUrls()) {
      newUrl.setProject(newProject);// newUrl already has an id
      urlRepo.save(newUrl); // with cascade, the urls are only created, not linked to the project
    }
    return newProject;// with "cascadeType=ALL" the urls are saved automatically
  }

  @Override
  public Projects updateProject(ProjectDto projectDto) {
    Projects foundProject = projectRepo.findById(projectDto.getProject().getId()).orElseThrow();
    Projects updatedProject = projectDto.getProject();
    foundProject.setTechs(updatedProject.getTechs());
    foundProject.setUrls(updatedProject.getUrls());
    return projectRepo.save(foundProject);
  }

  @Override
  public String deleteProject(UUID projectId) {
    projectRepo.findById(projectId).orElseThrow();
    projectRepo.deleteById(projectId);
    return "Project deleted successfully";
  }

  ///////////////////////////////

  @Override
  public List<Technologies> addTechToProject(UUID projectId, UUID techId) {
    Projects foundProject = projectRepo.findById(projectId).orElseThrow();
    Technologies foundTech = techRepo.findById(techId).orElseThrow();
    foundProject.addTech(foundTech);
    foundTech.addProject(foundProject);
    projectRepo.save(foundProject);
    techRepo.save(foundTech);
    return foundProject.getTechs();
  }

  @Override
  public List<Technologies> removeTechFromProject(UUID projectId, UUID techId) {
    Projects persistedProject = projectRepo.findById(projectId).orElseThrow();
    Technologies persistedTech = techRepo.findById(techId).orElseThrow();
    List<Projects> persistedTechProjects = persistedTech.getProjects();
    List<Technologies> persistedProjectTechs = persistedProject.getTechs();
    persistedProjectTechs.remove(persistedTech);
    persistedTechProjects.remove(persistedProject);
    projectRepo.save(persistedProject);
    techRepo.save(persistedTech);
    return persistedProjectTechs;
  }

  ///////////////////////////////

  @Override
  public List<ProjectUrl> getUrls() {
    return urlRepo.findAll();
  }

  @Override
  public ProjectUrl addUrl(ProjectUrl newUrl) {
    Projects foundProject = projectRepo.findById(newUrl.getProjectId()).orElseThrow();
    newUrl.setProject(foundProject);
    return urlRepo.save(newUrl);
  }

  @Override
  public ProjectUrl updateUrl(ProjectUrl url) {
    ProjectUrl oldUrl = urlRepo.findById(url.getId()).orElseThrow();
    if (url.getUrl() != null || !url.getUrl().isBlank()) {
      oldUrl.setUrl(url.getUrl());
    }
    if (url.getProjectId() != null) {
      Projects foundProject = projectRepo.findById(url.getProjectId()).orElseThrow();
      oldUrl.setProject(foundProject);
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