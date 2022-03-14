package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Experiences;

import com.heroku.demo.ServicesInterfaces.IExperiencesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/experiences")
public class ExperienceController {
  @Autowired
  private IExperiencesService experienceService;

  @GetMapping
  public void addExperience(Experiences experience) {
    /* techService.addTech(new Technologies(0, "React")); */
  }

}