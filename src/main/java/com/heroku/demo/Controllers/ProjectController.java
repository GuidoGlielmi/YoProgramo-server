package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.ProjectUrl;
import com.heroku.demo.Entities.Projects;
import com.heroku.demo.ServicesInterfaces.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
  public ResponseStateDto addProject(@RequestBody Projects project) {
    return new ResponseStateDto("Project added successfully", projectService.addProject(project));
  }

  @PutMapping
  public ResponseStateDto updateProject(@RequestBody Projects project) {
    return new ResponseStateDto("Project saved successfully", projectService.updateProject(project));
  }

  @DeleteMapping("/{id}")
  public ResponseStateDto deleteProject(@PathVariable UUID id) {
    return new ResponseStateDto("Project deleted successfully", projectService.deleteProject(id));
  }

  @PostMapping("/{projectId}/tech/{techId}")
  public ResponseStateDto addTechToProject(@PathVariable UUID projectId, @PathVariable UUID techId) {
    return new ResponseStateDto("Technology added to project successfully",
        projectService.addTechToProject(projectId, techId));
  }

  @DeleteMapping("/{projectId}/tech/{techId}")
  public ResponseStateDto removeTechFromProject(@PathVariable UUID projectId, @PathVariable UUID techId) {
    return new ResponseStateDto("Technology removed from project successfully",
        projectService.removeTechFromProject(projectId, techId));
  }

  @GetMapping("/url")
  public List<ProjectUrl> getUrls() {
    return projectService.getUrls();
  }

  @PostMapping("/url")
  public ResponseStateDto addUrl(@RequestBody ProjectUrl url) {
    return new ResponseStateDto("URL added successfully",
        projectService.addUrl(url).toString());
  }

  @PutMapping("/url")
  public ResponseStateDto updateUrl(@RequestBody ProjectUrl url) {
    return new ResponseStateDto("URL saved successfully",
        projectService.updateUrl(url));
  }

  @DeleteMapping("/url/{id}")
  public ResponseStateDto deleteUrl(@PathVariable UUID id) {
    return new ResponseStateDto("URL deleted successfully",
        projectService.deleteUrl(id));
  }

}