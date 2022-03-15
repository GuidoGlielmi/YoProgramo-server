package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.*;

@Entity
public class Education {
  @Id
  @SequenceGenerator(name = "education_id_seq", sequenceName = "education_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID education_id;

  private String school = "";
  private String startDate = "";
  private String endDate = "";
  private String degree = "";

  public UUID getEducation_id() {
    return this.education_id;
  }

  public void setEducation_id(UUID education_id) {
    this.education_id = education_id;
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
