package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.ServicesInterfaces.ITechService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
  public List<Technologies> addTech(@RequestBody Technologies tech) {
    return techService.addTech(tech);
  }

  @PutMapping
  public Technologies updateTech(@RequestBody Technologies tech) {
    return techService.updateTech(tech);
  }

  @DeleteMapping("/{id}")
  public List<Technologies> deleteTech(@PathVariable UUID id) {
    return techService.deleteTech(id);
  }

}