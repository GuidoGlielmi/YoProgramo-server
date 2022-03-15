package com.heroku.demo.Services;

import java.io.Serializable;
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
public class ProjectService implements IProjectService, Serializable {

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
  public String addProject(ProjectDto project) {
    try {
      Projects newProject = project.getProject();
      for (UUID techId : project.getTechs()) {
        Technologies tech = techRepo.findById(techId).get();
        newProject.addTech(tech);
      }
      projectRepo.save(newProject);
      for (ProjectUrl url : project.getUrls()) {
        url.setProject(newProject);
        urlRepo.save(url);
      }
      return "Project added successfully";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public Projects updateProject(ProjectDto projectDto) {
    Projects outdatedProject = projectRepo.findById(projectDto.getProject().getid()).orElseThrow();
    Projects updatedProject = projectDto.getProject();
    outdatedProject.setTechs(updatedProject.getTechs());
    outdatedProject.setUrls(updatedProject.getUrls());
    return projectRepo.save(outdatedProject);
  }

  @Override
  public String deleteProject(UUID projectId) {
    projectRepo.findById(projectId).orElseThrow();
    projectRepo.deleteById(projectId);
    return "Project deleted successfully";
  }

  ///////////////////////////////

  @Override
  public String addTechToProject(UUID projectId, UUID techId) {
    try {
      Projects selectedProject = projectRepo.findById(projectId).get();
      Technologies selectedTech = techRepo.findById(techId).get();
      selectedProject.addTech(selectedTech);
      selectedTech.addProject(selectedProject);
      projectRepo.save(selectedProject);
      techRepo.save(selectedTech);
      return "Technology item added to project successfully";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public String removeTechFromProject(UUID projectId, UUID techId) {
    Projects selectedProject = projectRepo.findById(projectId).orElseThrow();
    List<Technologies> techs = selectedProject.getTechs();
    for (Technologies tech : techs) {
      if (tech.getId() == techId) {
        techs.remove(techs.indexOf(tech));
      }
    }
    return "Technology item deleted from project successfully";
  }

  ///////////////////////////////

  @Override
  public List<ProjectUrl> getUrls() {
    return urlRepo.findAll();
  }

  @Override
  public String addUrl(ProjectUrl url) {
    try {
      UUID projectId = url.getId();
      Projects selectedProject = projectRepo.findById(projectId).get();
      url.setProject(selectedProject);
      urlRepo.save(url);
      return "URL item added to project successfully";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public ProjectUrl updateUrl(ProjectUrl url) {
    ProjectUrl selectedUrl = urlRepo.findById(url.getId()).orElseThrow();
    selectedUrl = url;
    return selectedUrl;
  }

  @Override
  public String deleteUrl(UUID id) {
    urlRepo.findById(id).orElseThrow();
    urlRepo.deleteById(id);
    return "URL item deleted from project successfully";
  }
}