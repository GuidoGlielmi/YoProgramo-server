package com.heroku.demo.Controllers;

import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.Experiences;

import com.heroku.demo.ServicesInterfaces.IExperiencesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("experiences")
public class ExperienceController {
  @Autowired
  private IExperiencesService experienceService;

  @GetMapping
  public ResponseEntity<ResponseStateDto> getExperiences(Experiences experience) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(experienceService.getExperiences(experience));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping
  public ResponseEntity<ResponseStateDto> addExperience(@RequestBody Experiences experience) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(experienceService.addExperience(experience).toString());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PutMapping
  public ResponseEntity<ResponseStateDto> updateExperience(@RequestBody Experiences experience) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(experienceService.updateExperience(experience));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseStateDto> deleteExperience(@PathVariable UUID id) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(experienceService.deleteExperience(id));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }
}