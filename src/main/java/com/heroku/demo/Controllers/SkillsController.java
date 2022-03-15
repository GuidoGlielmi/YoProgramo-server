package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Skills;

import com.heroku.demo.ServicesInterfaces.ISkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("skills")
public class SkillsController {
  @Autowired
  private ISkillService skillsService;

  @GetMapping
  public void getSkills() {
    skillsService.getSkills();
  }

  @PostMapping
  public void addSkill(Skills skill) {
    skillsService.addSkill(skill);
  }

  @PutMapping
  public void updateSkill(Skills skill, long id) {
    skillsService.updateSkill(skill, id);
  }

  @DeleteMapping
  public void deleteSkill(long id) {
    skillsService.deleteSkill(id);
  }

}
