package com.heroku.demo.Entities;

import java.util.UUID;
import javax.persistence.*;

@Entity
public class Skills {
  @Id
  @SequenceGenerator(name = "skills_id_seq", sequenceName = "skills_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID skill_id;

  private String name = "";
  private int abilityPercentage = 0;
  private String type = "";

  public UUID getSkill_id() {
    return this.skill_id;
  }

  public void setSkill_id(UUID skill_id) {
    this.skill_id = skill_id;
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
