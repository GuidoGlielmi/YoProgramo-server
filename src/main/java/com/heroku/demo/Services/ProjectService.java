package com.heroku.demo.Services;

import com.heroku.demo.Entities.ProjectTechnologies;
import com.heroku.demo.Entities.ProjectUrls;
import com.heroku.demo.Entities.Projects;
import com.heroku.demo.ServicesInterfaces.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {
  @Autowired
  Projects project;
  @Autowired
  ProjectUrls urls;
  @Autowired
  ProjectTechnologies techs;

  @Override
  public void addProject(Projects project, ProjectUrls urls, ProjectTechnologies techs) {

  }

}
