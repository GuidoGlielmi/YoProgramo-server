package com.heroku.demo.Entities;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Technologies {
  @Id
  @SequenceGenerator(name = "technologies_id_seq", sequenceName = "technologies_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String name = "";
  @JsonIgnore // This avoids recursion
  @ManyToMany(mappedBy = "technologies")
  private List<Projects> projects = new ArrayList<Projects>();

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
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

  public void addProject(Projects project) {
    this.projects.add(project);
  }

}
