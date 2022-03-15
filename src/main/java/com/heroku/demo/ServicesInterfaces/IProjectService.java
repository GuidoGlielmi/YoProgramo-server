package com.heroku.demo.ServicesInterfaces;

import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.ProjectUrl;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ProjectDto;

public interface IProjectService {

  public List<Projects> getProjects();

  public String addProject(ProjectDto project);

  public Projects updateProject(ProjectDto project);

  public String deleteProject(UUID projectId);

  public String addTechToProject(UUID projectId, UUID techId);

  public String removeTechFromProject(UUID id, UUID techId);

  public List<ProjectUrl> getUrls();

  public String addUrl(ProjectUrl url);

  public String deleteUrl(UUID id);

  public ProjectUrl updateUrl(ProjectUrl url);

}
