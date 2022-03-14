package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Skills;

import com.heroku.demo.ServicesInterfaces.ISkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/skills")
public class SkillsController {
  @Autowired
  private ISkillService skillsService;

  @GetMapping
  public void addSkills(Skills skills) {
    /* techService.addTech(new Technologies(0, "React")); */
  }

}
