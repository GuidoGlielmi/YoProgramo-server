package com.heroku.demo.DTO;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.*;

public class ProjectDto {
  private Projects project;
  private List<ProjectUrl> urls;

  private List<UUID> techs;

  public ProjectDto(Projects project, List<ProjectUrl> urls, List<UUID> techs) {
    this.project = project;
    this.urls = urls;
    this.techs = techs;
  }

  public Projects getProject() {
    return this.project;
  }

  public void setProject(Projects project) {
    this.project = project;
  }

  public List<UUID> getTechs() {
    return this.techs;
  }

  public void setTechs(List<UUID> techs) {
    this.techs = techs;
  }

  public List<ProjectUrl> getUrls() {
    return this.urls;
  }

  public void setUrls(List<ProjectUrl> urls) {
    this.urls = urls;
  }

}
