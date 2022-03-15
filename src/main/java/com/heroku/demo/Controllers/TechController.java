package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

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
  public List<Technologies> getProjects() {
    return techService.getTechs();
  }

  @PostMapping
  public void addTech(@RequestBody Technologies tech) {
    techService.addTech(tech);
  }

  @PutMapping
  public void updateTech(@RequestBody Technologies tech) {
    techService.updateTech(tech);
  }

  @DeleteMapping("/{id}")
  public void deleteTech(@PathVariable UUID id) {
    techService.deleteTech(id);
  }

}