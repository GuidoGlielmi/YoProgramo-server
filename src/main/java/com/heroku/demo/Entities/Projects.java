package com.heroku.demo.Entities;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projects {
  @Id
  //@SequenceGenerator(name = "projects_id_seq", sequenceName = "projects_id_seq", allocationSize = 1)
  @GeneratedValue //AUTO by default
  private UUID id;
  private String title = "";
  private String description = "";
  private String projectImg = "";
  private String deployUrl = "";
  @ManyToMany
  // Project IS the owner, so when deleting the project, it will automatically be removed from every single tech's project list
  private List<Technologies> techs = new ArrayList<Technologies>();
  @OneToMany(mappedBy = "project", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
  // mappedBy sets the parent entity. Cascade's PERSIST type creates the url when creating the project, but without linking the url to the project.
  // With lazy initialization approach, it will get initialized only when explicitly calling it, using a getter or some other method.
  private List<ProjectUrl> urls = new ArrayList<ProjectUrl>();

  /* @JoinColumn creates a column in the many side of the relation with the given name that references the PK of the parent entity, unless referencedColumnName is specified */

  public Projects(String title, String description, String projectImg, List<Technologies> techs,
      List<ProjectUrl> urls, String deployUrl) {
    this.title = title;
    this.description = description;
    this.projectImg = projectImg;
    this.deployUrl = deployUrl;
    this.techs = techs;
    this.urls = urls;
  }

  public Projects(String title, String description, String projectImg, List<Technologies> techs,
      List<ProjectUrl> urls) {
    this.title = title;
    this.description = description;
    this.projectImg = projectImg;
    this.techs = techs;
    this.urls = urls;
  }

  public void addTech(Technologies tech) {
    this.techs.add(tech);
  }

  public void addUrl(ProjectUrl url) {
    this.urls.add(url);
  }

}
