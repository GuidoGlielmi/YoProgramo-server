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
  public UUID addProject(ProjectDto project) {
    Projects newProject = project.getProject();
    for (UUID techId : project.getTechs()) {
      Technologies tech = techRepo.findById(techId).orElseThrow();
      newProject.addTech(tech);
    }
    Projects persistedProject = projectRepo.save(newProject);
    for (ProjectUrl url : project.getUrls()) {
      url.setProject(persistedProject);
      urlRepo.save(url);
    }
    return persistedProject.getId();
  }

  @Override
  public Projects updateProject(ProjectDto projectDto) {
    Projects outdatedProject = projectRepo.findById(projectDto.getProject().getId()).orElseThrow();
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
  public List<Technologies> addTechToProject(UUID projectId, UUID techId) {
    Projects selectedProject = projectRepo.findById(projectId).orElseThrow();
    Technologies selectedTech = techRepo.findById(techId).orElseThrow();
    selectedProject.addTech(selectedTech);
    selectedTech.addProject(selectedProject);
    projectRepo.save(selectedProject);
    techRepo.save(selectedTech);
    return selectedProject.getTechs();
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
  public ProjectUrl addUrl(UUID projectId, ProjectUrl url) {
    Projects selectedProject = projectRepo.findById(projectId).orElseThrow();
    url.setProject(selectedProject);
    return urlRepo.save(url);
  }

  @Override
  public ProjectUrl updateUrl(ProjectUrl url) {
    ProjectUrl selectedUrl = urlRepo.findById(url.getId()).orElseThrow();
    selectedUrl = url;
    return selectedUrl;
  }

  @Override
  public List<ProjectUrl> deleteUrl(UUID id) {
    ProjectUrl selectedUrl = urlRepo.findById(id).orElseThrow();
    urlRepo.deleteById(id);
    Projects project = projectRepo.findById(selectedUrl.getProjectId()).orElseThrow();
    return project.getUrls();
  }
}