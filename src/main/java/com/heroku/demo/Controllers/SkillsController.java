package com.heroku.demo.Controllers;

import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.Skills;

import com.heroku.demo.ServicesInterfaces.ISkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("skills")
public class SkillsController {
  @Autowired
  private ISkillService skillsService;

  @GetMapping
  public ResponseEntity<ResponseStateDto> getSkills() {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(skillsService.getSkills());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping
  public ResponseEntity<ResponseStateDto> addSkill(@RequestBody Skills skill) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(skillsService.addSkill(skill).toString());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PutMapping
  public ResponseEntity<ResponseStateDto> updateSkill(@RequestBody Skills skill) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(skillsService.updateSkill(skill));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseStateDto> deleteSkill(@PathVariable UUID id) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(skillsService.deleteSkill(id));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

}
