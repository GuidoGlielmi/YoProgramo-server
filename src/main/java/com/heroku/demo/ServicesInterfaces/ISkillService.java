package com.heroku.demo.ServicesInterfaces;

import java.util.UUID;
import java.util.List;

import com.heroku.demo.Entities.Skills;

public interface ISkillService {
  public List<Skills> getSkills();

  public List<Skills> addSkill(Skills skill);

  public Skills updateSkill(Skills skill);

  public List<Skills> deleteSkill(UUID id);

}
