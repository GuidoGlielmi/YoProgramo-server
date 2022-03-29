package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
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
  public ResponseStateDto addTech(@RequestBody Technologies tech) {
    return new ResponseStateDto("Technology added successfully", techService.addTech(tech).toString());
  }

  @PutMapping
  public ResponseStateDto updateTech(@RequestBody Technologies tech) {
    return new ResponseStateDto("Technology saved successfully", techService.updateTech(tech));
  }

  @DeleteMapping("/{id}")
  public ResponseStateDto deleteTech(@PathVariable UUID id) {
    return new ResponseStateDto("Technology deleted successfully", techService.deleteTech(id));
  }

}