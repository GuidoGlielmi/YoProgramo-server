package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.ProjectUrls;
import com.heroku.demo.Entities.ProjectTechnologies;
import com.heroku.demo.ServicesInterfaces.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/projects")
public class ProjectController {
  @Autowired
  private IProjectService projectService;

  @GetMapping
  public void addProject(Projects project, ProjectUrls urls, ProjectTechnologies techs) {
    /* techService.addTech(new Technologies(0, "React")); */
  }

}