package com.heroku.demo.Controllers;

import java.util.List;

import com.heroku.demo.Entities.Education;

import com.heroku.demo.ServicesInterfaces.IEducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
  public void addEducation(Education education) {
    educationService.addEducation(education);
  }

  @PutMapping
  public void updateEducation(Education education, long id) {
    educationService.updateEducation(education, id);
  }

  @DeleteMapping
  public void deleteEducation(long id) {
    educationService.deleteEducation(id);
  }

}
