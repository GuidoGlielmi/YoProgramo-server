package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

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
  public List<Skills> getSkills() {
    return skillsService.getSkills();
  }

  @PostMapping
  public void addSkill(@RequestBody Skills skill) {
    skillsService.addSkill(skill);
  }

  @PutMapping
  public void updateSkill(@RequestBody Skills skill) {
    skillsService.updateSkill(skill);
  }

  @DeleteMapping("/{id}")
  public void deleteSkill(@PathVariable UUID id) {
    skillsService.deleteSkill(id);
  }

}
