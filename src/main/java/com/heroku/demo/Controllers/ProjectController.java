package com.heroku.demo.Controllers;

import java.util.List;

import com.heroku.demo.DTO.ProjectDto;
import com.heroku.demo.Entities.ProjectUrl;
import com.heroku.demo.Entities.Projects;
import com.heroku.demo.ServicesInterfaces.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projects")
public class ProjectController {
  @Autowired
  private IProjectService projectService;

  @GetMapping
  public List<Projects> getProjects() {
    return projectService.getProjects();
  }

  @PostMapping
  public void addProject(@RequestBody Projects project) {
    projectService.addProject(project);
  }

  @PostMapping("/url")
  public void addUrl(@RequestBody ProjectUrl url) {
    projectService.addUrl(url);
  }

  @PostMapping("/{projectId}/url")
  public void addUrl(@PathVariable long projectId, @RequestBody ProjectUrl url) {
    projectService.addUrlToProject(projectId, url);
  }

  @PostMapping("/{projectId}/tech/{techId}")
  public void addProjectTech(@PathVariable long projectId, @PathVariable long techId) {
    projectService.addProjectTech(projectId, techId);
  }

  @PostMapping("/{projectId}/url/{urlId}")
  public void addProjectUrl(@PathVariable long projectId, @PathVariable long urlId) {
    projectService.addProjectUrl(projectId, urlId);
  }

  @PostMapping("/tuvieja")
  public void addCompleteProject(@RequestBody ProjectDto project) {
    projectService.addCompleteProject(project);
  }

  // return new ResponseEntity<>(projectService.addProjectTech(techId, projectId), HttpStatus.CREATED)
}