package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
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

  @PostMapping /* (produces = "application/json") */
  // return "{\"test\": \"Hello using @ResponseBody\"}";
  public ResponseStateDto addEducation(@RequestBody Education education) {
    return new ResponseStateDto("Education added successfully", educationService.addEducation(education).toString());
  }

  @PutMapping
  public ResponseStateDto updateEducation(@RequestBody Education education) {
    educationService.updateEducation(education);
    return new ResponseStateDto("Education saved successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseStateDto deleteEducation(@PathVariable UUID id) {
    educationService.deleteEducation(id);
    return new ResponseStateDto("Education deleted successfully");
  }

}
