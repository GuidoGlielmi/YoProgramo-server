package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.lang.NonNull;

@Entity
public class ProjectUrl {
  @Id
  @GeneratedValue
  private UUID id;
  @NonNull
  private String url;
  @ManyToOne(fetch = FetchType.LAZY) // with just @ManyToOne the corresponding table is created but urls are not included in the projects themselves
  @JsonIgnore
  private Projects project;

  @JsonInclude()
  @Transient
  private UUID projectId;

  // Every function starting with "get" gets included when calling findAll()
  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Projects getProject() {
    return this.project;
  }

  public void setProject(Projects project) {
    this.project = project;
  }

  public UUID getProjectId() {
    return project != null ? project.getId() : projectId;
  }

}
