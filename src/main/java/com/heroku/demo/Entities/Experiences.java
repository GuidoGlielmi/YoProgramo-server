package com.heroku.demo.Entities;

import java.util.UUID;
import javax.persistence.*;

@Entity
public class Experiences {
  @Id
  @GeneratedValue
  private UUID id;
  private String title = "";
  private String startDate = "";
  private String endDate = "";
  private String description = "";
  private String experienceImg = "";
  private String certificate = "";

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

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getExperienceImg() {
    return this.experienceImg;
  }

  public void setExperienceImg(String experienceImg) {
    this.experienceImg = experienceImg;
  }

  public String getCertificate() {
    return this.certificate;
  }

  public void setCertificate(String certificate) {
    this.certificate = certificate;
  }

}
