package com.heroku.demo.DTO;

import java.util.UUID;
import java.io.Serializable;
import com.heroku.demo.Entities.ProjectUrl;

public class ProjectUrlDto implements Serializable {
  private ProjectUrl projectUrl;
  private UUID projectId;

  public ProjectUrl getProjectUrl() {
    return this.projectUrl;
  }

  public void setProjectUrl(ProjectUrl projectUrl) {
    this.projectUrl = projectUrl;
  }

  public UUID getProjectId() {
    return this.projectId;
  }

  public void setProjectId(UUID project) {
    this.projectId = project;
  }

}
