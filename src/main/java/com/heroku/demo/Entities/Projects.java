package com.heroku.demo.Entities;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Projects {
  @Id
  @SequenceGenerator(name = "projects_id_seq", sequenceName = "projects_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String title;
  private String description;
  @ManyToMany
  /* @Jointable(
    name = "project_technologies", 
    joinColumns = @JoinColumn(name = "project_id"), 
    inverseJoinColumns = @JoinColumn(name = "technology_id")) */
  private List<Technologies> technologies = new ArrayList<Technologies>();
  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL) // cascade removes the urls when removing the related project
  private List<ProjectUrl> urls = new ArrayList<ProjectUrl>();

  public UUID getid() {
    return this.id;
  }

  public void setid(UUID id) {
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

  public List<Technologies> getTechs() {
    return this.technologies;
  }

  public void setTechs(List<Technologies> technologies) {
    this.technologies = technologies;
  }

  public void addTech(Technologies tech) {
    this.technologies.add(tech);
  }

  public List<ProjectUrl> getUrls() {
    return this.urls;
  }

  public void setUrls(List<ProjectUrl> urls) {
    this.urls = urls;
  }
}
