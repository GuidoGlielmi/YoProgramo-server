package com.heroku.demo.ServicesInterfaces;

import java.util.UUID;
import java.util.List;

import com.heroku.demo.Entities.Skills;

public interface ISkillService {
  public List<Skills> getSkills();

  public Skills addSkill(Skills skill);

  public Skills updateSkill(Skills skill);

  public String deleteSkill(UUID id);

}
