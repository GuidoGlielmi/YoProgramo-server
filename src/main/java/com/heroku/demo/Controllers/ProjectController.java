package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

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
  public String addProject(@RequestBody ProjectDto project) {
    return projectService.addProject(project);
  }

  @DeleteMapping("/{id}")
  public String deleteProject(@PathVariable UUID id) {
    return projectService.deleteProject(id);
  }

  @PostMapping("/{projectId}/tech/{techId}")
  public String addProjectTech(@PathVariable UUID projectId, @PathVariable UUID techId) {
    return projectService.addTechToProject(projectId, techId);
  }

  @GetMapping("/url")
  public List<ProjectUrl> getUrls() {
    return projectService.getUrls();
  }

  @PutMapping("/url")
  public ProjectUrl updateUrl(@RequestBody ProjectUrl url) {
    return projectService.updateUrl(url);
  }

  @DeleteMapping("/url/{id}")
  public String deleteUrl(@PathVariable UUID id) {
    return projectService.deleteUrl(id);
  }

  @PostMapping("/url")
  public void addUrl(@RequestBody ProjectUrl url) {
    projectService.addUrl(url);
  }

  // return new ResponseEntity<>(projectService.addProjectTech(techId, projectId), HttpStatus.CREATED)
}