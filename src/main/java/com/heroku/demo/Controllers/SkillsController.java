package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
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
  public ResponseStateDto addSkill(@RequestBody Skills skill) {
    return new ResponseStateDto("Skill added successfully", skillsService.addSkill(skill).toString());
  }

  @PutMapping
  public ResponseStateDto updateSkill(@RequestBody Skills skill) {
    return new ResponseStateDto("Skill saved successfully", skillsService.updateSkill(skill));
  }

  @DeleteMapping("/{id}")
  public ResponseStateDto deleteSkill(@PathVariable UUID id) {
    return new ResponseStateDto("Skill deleted successfully", skillsService.deleteSkill(id));
  }

}
