package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.ServicesInterfaces.ITechsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TechsController {
  @Autowired
  private ITechsService techService;

  @GetMapping("/techs")
  public void addProject() {
    /* techService.addTech(new Technologies(0, "React")); */
  }

}