package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.*;

@Entity
public class Education {
  @Id
  @GeneratedValue
  private UUID id;

  private String school = "";
  private String startDate = "";
  private String endDate = "";
  private String degree = "";

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getSchool() {
    return this.school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getStartDate() {
    return this.startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return this.endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getDegree() {
    return this.degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

}
