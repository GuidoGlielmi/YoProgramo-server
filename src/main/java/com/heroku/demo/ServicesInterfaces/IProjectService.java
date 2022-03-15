package com.heroku.demo.ServicesInterfaces;

import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.ProjectUrl;

import java.util.List;

import com.heroku.demo.DTO.ProjectDto;

public interface IProjectService {
  public List<Projects> getProjects();

  public void addProject(Projects project);

  public void addProjectTech(long projectId, long techId);

  public void addProjectUrl(long projectId, long urlId);

  public void addUrl(ProjectUrl url);

  public void addUrlToProject(long projectId, ProjectUrl url);

  public void addCompleteProject(ProjectDto project);

}
