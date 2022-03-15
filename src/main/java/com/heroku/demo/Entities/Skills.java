package com.heroku.demo.Entities;

import javax.persistence.*;

@Entity
public class Skills {
  @Id
  @SequenceGenerator(name = "skills_id_seq", sequenceName = "skills_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long skill_id;

  private String name;
  private int abilityPercentage;
  private String type;

  public long getSkill_id() {
    return this.skill_id;
  }

  public void setSkill_id(long skill_id) {
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
