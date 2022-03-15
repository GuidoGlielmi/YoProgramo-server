package com.heroku.demo.Services;

import java.util.List;

import com.heroku.demo.Entities.Skills;
import com.heroku.demo.Repositories.SkillRepo;
import com.heroku.demo.ServicesInterfaces.ISkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService {
  @Autowired
  SkillRepo skillRepo;

  @Override
  public List<Skills> getSkills() {
    return skillRepo.findAll();
  }

  @Override
  public void addSkill(Skills skill) {
    skillRepo.save(skill);
  }

  @Override
  public void updateSkill(Skills skill, long id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteSkill(long id) {
    skillRepo.deleteById(id);
  }

}
