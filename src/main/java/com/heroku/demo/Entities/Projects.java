package com.heroku.demo.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Projects {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String title;
  private String description;
  @ManyToMany
  /* @Jointable(
    name = "project_technologies", 
    joinColumns = @JoinColumn(name = "project_id"), 
    inverseJoinColumns = @JoinColumn(name = "technology_id")) */
  private List<Technologies> technologies;

  public long getid() {
    return this.id;
  }

  public void setid(long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Technologies> getTechnologies() {
    return this.technologies;
  }

  public void setTechnologies(List<Technologies> technologies) {
    this.technologies = technologies;
  }
}
