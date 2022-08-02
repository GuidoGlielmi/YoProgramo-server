package com.heroku.demo.Controllers;

import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.ServicesInterfaces.ITechService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("techs")
public class TechController {
  @Autowired
  private ITechService techService;

  @GetMapping
  public ResponseEntity<ResponseStateDto> getProjects() {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(techService.getTechs());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping
  public ResponseEntity<ResponseStateDto> addTech(@RequestBody Technologies tech) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(techService.addTech(tech).toString());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PutMapping
  public ResponseEntity<ResponseStateDto> updateTech(@RequestBody Technologies tech) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(techService.updateTech(tech));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseStateDto> deleteTech(@PathVariable UUID id) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(techService.deleteTech(id));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

}