package com.heroku.demo.ServicesInterfaces;

import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.Entities.ProjectUrl;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ProjectDto;

public interface IProjectService {

  public List<Projects> getProjects();

  public Projects addProject(ProjectDto project);

  public Projects updateProject(ProjectDto project);

  public List<Projects> deleteProject(UUID projectId);

  public List<Technologies> addTechToProject(UUID projectId, UUID techId);

  public List<Technologies> removeTechFromProject(UUID id, UUID techId);

  public List<ProjectUrl> getUrls();

  public UUID addUrl(ProjectUrl url);

  public List<ProjectUrl> deleteUrl(UUID id);

  public ProjectUrl updateUrl(ProjectUrl url);

}
