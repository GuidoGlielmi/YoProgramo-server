package com.heroku.demo.Controllers;

import java.util.UUID;
import java.util.List;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.Experiences;

import com.heroku.demo.ServicesInterfaces.IExperiencesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("experiences")
public class ExperienceController {
  @Autowired
  private IExperiencesService experienceService;

  @GetMapping
  public List<Experiences> getExperiences(Experiences experience) {
    return experienceService.getExperiences(experience);
  }

  @PostMapping
  public ResponseStateDto addExperience(@RequestBody Experiences experience) {
    return new ResponseStateDto("Experience added successfully",
        experienceService.addExperience(experience).toString());
  }

  @PutMapping
  public ResponseStateDto updateExperience(@RequestBody Experiences experience) {
    return new ResponseStateDto("Experience saved successfully", experienceService.updateExperience(experience));
  }

  @DeleteMapping("/{id}")
  public ResponseStateDto deleteExperience(@PathVariable UUID id) {
    return new ResponseStateDto("Experience deleted successfully", experienceService.deleteExperience(id));

  }
}