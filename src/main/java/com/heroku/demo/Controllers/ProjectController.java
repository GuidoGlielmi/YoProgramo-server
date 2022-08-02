package com.heroku.demo.Controllers;

import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.ProjectUrl;
import com.heroku.demo.Entities.Projects;
import com.heroku.demo.ServicesInterfaces.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projects")
public class ProjectController {

  @Autowired
  private IProjectService projectService;

  @GetMapping
  public ResponseEntity<ResponseStateDto> getProjects() {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.getProjects());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping
  public ResponseEntity<ResponseStateDto> addProject(@RequestBody Projects project) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.addProject(project));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PutMapping
  public ResponseEntity<ResponseStateDto> updateProject(@RequestBody Projects project) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.updateProject(project));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseStateDto> deleteProject(@PathVariable UUID id) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.deleteProject(id));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping("/{projectId}/tech/{techId}")
  public ResponseEntity<ResponseStateDto> addTechToProject(@PathVariable UUID projectId, @PathVariable UUID techId) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.addTechToProject(projectId, techId));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @DeleteMapping("/{projectId}/tech/{techId}")
  public ResponseEntity<ResponseStateDto> removeTechFromProject(@PathVariable UUID projectId,
      @PathVariable UUID techId) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.removeTechFromProject(projectId, techId));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @GetMapping("/url")
  public ResponseEntity<ResponseStateDto> getUrls() {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.getUrls());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping("/url")
  public ResponseEntity<ResponseStateDto> addUrl(@RequestBody ProjectUrl url) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.addUrl(url).toString());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PutMapping("/url")
  public ResponseEntity<ResponseStateDto> updateUrl(@RequestBody ProjectUrl url) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.updateUrl(url));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @DeleteMapping("/url/{id}")
  public ResponseEntity<ResponseStateDto> deleteUrl(@PathVariable UUID id) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(projectService.deleteUrl(id));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

}