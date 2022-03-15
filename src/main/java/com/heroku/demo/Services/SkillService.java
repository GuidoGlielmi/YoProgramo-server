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
  public String addSkill(Skills skill) {
    try {
      skillRepo.save(skill);
      return "Skill item deleted successfully";

    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public Skills updateSkill(Skills skill) {
    UUID id = skill.getSkill_id();
    Skills selectedSkill = skillRepo.findById(id).orElseThrow();
    if (!skill.getName().isBlank()) {
      selectedSkill.setName(skill.getName());
    }
    if (!skill.getType().isBlank()) {
      selectedSkill.setType(skill.getType());
    }
    if (skill.getAbilityPercentage() != 0) {
      selectedSkill.setAbilityPercentage(skill.getAbilityPercentage());
    }
    skillRepo.save(selectedSkill);
    return selectedSkill;
  }

  @Override
  public String deleteSkill(UUID id) {
    skillRepo.findById(id).orElseThrow();
    skillRepo.deleteById(id);
    return "Skill item deleted successfully";
  }

}
