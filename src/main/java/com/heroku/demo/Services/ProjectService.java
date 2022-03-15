package com.heroku.demo.Services;

import java.io.Serializable;
import java.util.List;

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
  public void addProject(Projects project) {
    projectRepo.save(project);
  }

  @Override
  public List<Projects> getProjects() {
    return projectRepo.findAll();
  }

  @Override
  public void addProjectTech(long projectId, long techId) {
    Projects selectedProject = projectRepo.findById(projectId).get();
    Technologies selectedTech = techRepo.findById(techId).get();
    selectedProject.addTechnology(selectedTech);
    selectedTech.addProject(selectedProject);
    projectRepo.save(selectedProject);
    techRepo.save(selectedTech);
  }

  @Override
  public void addProjectUrl(long projectId, long urlId) {
    Projects selectedProject = projectRepo.findById(projectId).get();
    ProjectUrl selectedUrl = urlRepo.findById(urlId).get();
    selectedUrl.setProject(selectedProject);
    //It is mandatory to add the project to the url, the one to the many and not viceversa
    urlRepo.save(selectedUrl);
  }

  @Override
  public void addUrl(ProjectUrl url) {
    urlRepo.save(url);
  }

  @Override
  public void addUrlToProject(long projectId, ProjectUrl url) {
    Projects selectedProject = projectRepo.findById(projectId).get();
    url.setProject(selectedProject);
    urlRepo.save(url);
  }

  @Override
  public void addCompleteProject(ProjectDto wholeProject) {
    Projects newProject = wholeProject.getProject();
    for (long techId : wholeProject.getTechs()) {
      Technologies tech = techRepo.findById(techId).get();
      newProject.addTechnology(tech);
    }
    projectRepo.save(newProject);
    for (ProjectUrl url : wholeProject.getUrls()) {
      url.setProject(newProject);
      urlRepo.save(url);
    }

  }

}
