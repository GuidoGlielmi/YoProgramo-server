package com.heroku.demo.Entities;

import javax.persistence.*;

@Entity
public class ProjectUrls {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String url;
  @ManyToOne
  @JoinColumn
  private Projects project;

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
