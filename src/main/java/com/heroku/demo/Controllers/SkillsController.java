package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.Skills;

import com.heroku.demo.ServicesInterfaces.ISkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
  public List<Skills> addSkill(@RequestBody Skills skill) {
    return skillsService.addSkill(skill);
  }

  @PutMapping
  public Skills updateSkill(@RequestBody Skills skill) {
    return skillsService.updateSkill(skill);
  }

  @DeleteMapping("/{id}")
  public List<Skills> deleteSkill(@PathVariable UUID id) {
    return skillsService.deleteSkill(id);
  }

}
