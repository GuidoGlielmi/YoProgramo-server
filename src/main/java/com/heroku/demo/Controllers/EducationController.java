package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.Education;

import com.heroku.demo.ServicesInterfaces.IEducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("education")
public class EducationController {
  @Autowired
  private IEducationService educationService;

  @GetMapping
  public List<Education> getEducation() {
    return educationService.getEducation();
  }

  @PostMapping
  public List<Education> addEducation(@RequestBody Education education) {
    return educationService.addEducation(education);
  }

  @PutMapping
  public Education updateEducation(@RequestBody Education education) {
    return educationService.updateEducation(education);
  }

  @DeleteMapping("/{id}")
  public List<Education> deleteEducation(@PathVariable UUID id) {
    return educationService.deleteEducation(id);
  }

}
