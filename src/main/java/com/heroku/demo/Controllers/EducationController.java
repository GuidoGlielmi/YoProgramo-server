package com.heroku.demo.Controllers;

import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.Education;

import com.heroku.demo.ServicesInterfaces.IEducationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("education")
public class EducationController {
  @Autowired
  private IEducationService educationService;

  @GetMapping
  public ResponseEntity<ResponseStateDto> getEducation() {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(educationService.getEducation());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping /* (produces = "application/json") */
  // return "{\"test\": \"Hello using @ResponseBody\"}";
  @ResponseStatus(value = HttpStatus.CREATED)
  public ResponseEntity<ResponseStateDto> addEducation(@RequestBody Education education) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(educationService.addEducation(education).toString());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PutMapping
  public ResponseEntity<ResponseStateDto> updateEducation(@RequestBody Education education) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(educationService.updateEducation(education));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseStateDto> deleteEducation(@PathVariable UUID id) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(educationService.deleteEducation(id));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

}
