package com.heroku.demo.Entities;

import java.util.UUID;
import javax.persistence.*;

@Entity
public class Skills {
  @Id
  @GeneratedValue
  private UUID id;

  private String name = "";
  private int abilityPercentage = 0;
  private String type = "";

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAbilityPercentage() {
    return this.abilityPercentage;
  }

  public void setAbilityPercentage(int abilityPercentage) {
    this.abilityPercentage = abilityPercentage;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
