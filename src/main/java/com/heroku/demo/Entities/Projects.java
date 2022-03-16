package com.heroku.demo.Entities;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Projects {
  @Id
  //@SequenceGenerator(name = "projects_id_seq", sequenceName = "projects_id_seq", allocationSize = 1)
  @GeneratedValue //AUTO by default
  private UUID id;
  private String title;
  private String description;
  @ManyToMany
  // Project IS the owner, so when deleting the project, it will automatically be removed from every single tech's project list
  private List<Technologies> technologies = new ArrayList<Technologies>();
  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // cascade removes the urls when removing the related project. With lazy initialization approach, it will get initialized only when explicitly calling it, using a getter or some other method.
  private List<ProjectUrl> urls = new ArrayList<ProjectUrl>();

  /* @JoinColumn creates a column in the many side of the relation with the given name that references the PK of the parent entity, unless referencedColumnName is specified */
  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
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
