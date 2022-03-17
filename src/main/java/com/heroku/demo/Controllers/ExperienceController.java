package com.heroku.demo.Controllers;

import java.util.UUID;
import java.util.List;

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
  public List<Experiences> addExperience(@RequestBody Experiences experience) {
    return experienceService.addExperience(experience);
  }

  @PutMapping
  public Experiences updateExperience(@RequestBody Experiences experience) {
    return experienceService.updateExperience(experience);
  }

  @DeleteMapping("/{id}")
  public List<Experiences> deleteExperience(@PathVariable UUID id) {
    return experienceService.deleteExperience(id);
  }
}