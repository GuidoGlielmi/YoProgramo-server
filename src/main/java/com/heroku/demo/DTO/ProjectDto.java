package com.heroku.demo.DTO;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.*;

public class ProjectDto {
  private Projects project;

  private List<UUID> techs;

  public ProjectDto(Projects project, List<UUID> techs) {
    //The constructor is necessary for building the DTO
    this.project = project;
    this.techs = techs;
  }

  public Projects getProject() {
    return this.project;
  }

  public void setProject(Projects project) {
    this.project = project;
  }

  public List<UUID> getTechsIds() {
    return this.techs;
  }

  public void setTechsIds(List<UUID> techs) {
    this.techs = techs;
  }

}
