package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.ServicesInterfaces.ITechService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("techs")
public class TechController {
  @Autowired
  private ITechService techService;

  @GetMapping
  public void getProjects() {
    techService.getTechs();
  }

  @PostMapping
  public void addTech(@RequestBody Technologies tech) {
    techService.addTech(tech);
  }

  @PutMapping
  public void updateTech(@RequestBody Technologies tech, @PathVariable long id) {
    techService.updateTech(tech, id);
  }

  @DeleteMapping("/{id}")
  public void deleteTech(@PathVariable long id) {
    techService.deleteTech(id);
  }

}