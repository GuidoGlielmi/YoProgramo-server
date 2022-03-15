package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

@Entity
public class ProjectUrl {
  @Id
  //@SequenceGenerator(name = "project_urls_id_seq", sequenceName = "project_urls_id_seq", allocationSize = 1)
  // @GeneratedValue(strategy = GenerationType.AUTO)
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID id;
  @NonNull
  private String url;
  @JsonIgnore
  @ManyToOne // with just @ManyToOne the corresponding table is created but urls are not included in the projects themselves
  // @JoinColumn(name = "project_id", referencedColumnName = "id")
  private Projects project;

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

}
