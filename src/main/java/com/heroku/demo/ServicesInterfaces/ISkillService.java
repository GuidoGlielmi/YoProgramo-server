package com.heroku.demo.ServicesInterfaces;

import java.util.List;

import com.heroku.demo.Entities.Skills;

public interface ISkillService {
  public List<Skills> getSkills();

  public void addSkill(Skills skill);

  public void updateSkill(Skills skill, long id);

  public void deleteSkill(long id);

}
