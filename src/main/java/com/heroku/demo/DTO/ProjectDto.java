package com.heroku.demo.DTO;

import com.heroku.demo.Entities.*;

public class ProjectDto {
  private Projects project;
  private ProjectTechnologies technologies;
  private ProjectUrls urls;

  public ProjectDto(Projects project, ProjectTechnologies technologies, ProjectUrls urls) {
    this.project = project;
    this.technologies = technologies;
    this.urls = urls;
  }

  public Projects getProject() {
    return this.project;
  }

  public void setProject(Projects project) {
    this.project = project;
  }

  public ProjectTechnologies getTechnologies() {
    return this.technologies;
  }

  public void setTechnologies(ProjectTechnologies technologies) {
    this.technologies = technologies;
  }

  public ProjectUrls getUrls() {
    return this.urls;
  }

  public void setUrls(ProjectUrls urls) {
    this.urls = urls;
  }

}
