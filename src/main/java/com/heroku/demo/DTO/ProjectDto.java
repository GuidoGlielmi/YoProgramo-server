package com.heroku.demo.DTO;

import java.util.List;

import com.heroku.demo.Entities.*;

public class ProjectDto {
  private Projects project;
  private List<ProjectUrl> urls;
  private List<Long> techs;

  public ProjectDto(Projects project, List<Long> techs, List<ProjectUrl> urls) {
    this.project = project;
    this.techs = techs;
    this.urls = urls;
  }

  public Projects getProject() {
    return this.project;
  }

  public void setProject(Projects project) {
    this.project = project;
  }

  public List<Long> getTechs() {
    return this.techs;
  }

  public void setTechs(List<Long> techs) {
    this.techs = techs;
  }

  public List<ProjectUrl> getUrls() {
    return this.urls;
  }

  public void setUrls(List<ProjectUrl> urls) {
    this.urls = urls;
  }

}
