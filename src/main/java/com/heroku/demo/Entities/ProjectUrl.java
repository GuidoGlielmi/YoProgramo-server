package com.heroku.demo.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProjectUrl {
  @Id
  @SequenceGenerator(name = "project_urls_id_seq", sequenceName = "project_urls_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String url;
  @JsonIgnore
  @ManyToOne(cascade = CascadeType.ALL) // with just @ManyToOne the corresponding table is created but urls are not included in the projects themselves
  // @JoinColumn(name = "project_id", referencedColumnName = "id")
  private Projects project;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
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
