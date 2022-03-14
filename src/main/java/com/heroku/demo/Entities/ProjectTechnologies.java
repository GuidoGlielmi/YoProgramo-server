package com.heroku.demo.Entities;

import javax.persistence.*;

public class ProjectTechnologies {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @ManyToMany
  @JoinColumn
  private Projects project;
  @ManyToMany
  @JoinColumn
  private Projects ProjectUrls;
}
