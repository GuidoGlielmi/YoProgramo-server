package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ProjectDto;
import com.heroku.demo.Entities.ProjectUrl;
import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.Technologies;
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
  public Projects addProject(@RequestBody ProjectDto project) {
    return projectService.addProject(project);
  }

  @PutMapping
  public Projects updateProject(@RequestBody ProjectDto project) {
    return projectService.updateProject(project);
  }

  @DeleteMapping("/{id}")
  public List<Projects> deleteProject(@PathVariable UUID id) {
    return projectService.deleteProject(id);
  }

  @PostMapping("/{projectId}/tech/{techId}")
  public List<Technologies> addTechToProject(@PathVariable UUID projectId, @PathVariable UUID techId) {
    return projectService.addTechToProject(projectId, techId);
  }

  @DeleteMapping("/{projectId}/tech/{techId}")
  public List<Technologies> removeTechFromProject(@PathVariable UUID projectId, @PathVariable UUID techId) {
    return projectService.removeTechFromProject(projectId, techId);
  }

  @GetMapping("/url")
  public List<ProjectUrl> getUrls() {
    return projectService.getUrls();
  }

  @PostMapping("/url")
  public List<ProjectUrl> addUrl(@RequestBody ProjectUrl url) {
    return projectService.addUrl(url);
  }

  @PutMapping("/url")
  public ProjectUrl updateUrl(@RequestBody ProjectUrl url) {
    return projectService.updateUrl(url);
  }

  @DeleteMapping("/url/{id}")
  public List<ProjectUrl> deleteUrl(@PathVariable UUID id) {
    return projectService.deleteUrl(id);
  }

}