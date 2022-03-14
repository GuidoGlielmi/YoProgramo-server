package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Education;

import com.heroku.demo.ServicesInterfaces.IEducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EducationController {
  @Autowired
  private IEducationService educationService;

  @GetMapping("/education")
  public void addEducation(Education education) {
    /* techService.addTech(new Technologies(0, "React")); */
  }

}
