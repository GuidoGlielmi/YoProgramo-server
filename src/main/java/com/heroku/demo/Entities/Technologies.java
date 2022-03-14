package com.heroku.demo.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Technologies {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @ManyToMany(mappedBy = "technologies")
  private List<Projects> projects;

  public Technologies(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public long getid() {
    return this.id;
  }

  public void setid(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Projects> getProjects() {
    return this.projects;
  }

  public void setProjects(List<Projects> projects) {
    this.projects = projects;
  }

}
