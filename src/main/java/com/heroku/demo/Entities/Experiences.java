package com.heroku.demo.Entities;

import java.util.UUID;
import javax.persistence.*;

@Entity
public class Experiences {
  @Id
  @SequenceGenerator(name = "experiences_id_seq", sequenceName = "experiences_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID experience_id;
  private String title = "";
  private String startDate = "";
  private String endDate = "";
  private String description = "";

  public UUID getExperience_id() {
    return this.experience_id;
  }

  public void setExperience_id(UUID experience_id) {
    this.experience_id = experience_id;
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

}
