package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.ServicesInterfaces.ITechService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/techs")
public class TechController {
  @Autowired
  private ITechService techService;

  @GetMapping
  public void addProject(Technologies tech) {
    /* techService.addTech(new Technologies(0, "React")); */
  }

}