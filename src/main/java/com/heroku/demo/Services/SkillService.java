package com.heroku.demo.Services;

import java.util.UUID;
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
  public Skills addSkill(Skills skill) {
    return skillRepo.save(skill);
  }

  @Override
  public Skills updateSkill(Skills skill) {
    UUID id = skill.getId();
    Skills foundSkill = skillRepo.findById(id).orElseThrow();
    if (!skill.getName().isBlank()) {
      foundSkill.setName(skill.getName());
    }
    if (!skill.getType().isBlank()) {
      foundSkill.setType(skill.getType());
    }
    if (skill.getAbilityPercentage() != 0) {
      foundSkill.setAbilityPercentage(skill.getAbilityPercentage());
    }
    return skillRepo.save(foundSkill);
  }

  @Override
  public String deleteSkill(UUID id) {
    skillRepo.delete(skillRepo.findById(id).orElseThrow());
    return "Skill item deleted successfully";
  }

}
