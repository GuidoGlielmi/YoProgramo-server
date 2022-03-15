package com.heroku.demo.Entities;

import javax.persistence.*;

// @Entity
public class ProjectTechnology {
  @Id
  @SequenceGenerator(name = "project_technologies_id_seq", sequenceName = "project_technologies_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @ManyToMany
  @JoinColumn
  private Projects project;
  @ManyToMany
  @JoinColumn
  private Projects ProjectUrls;
}
