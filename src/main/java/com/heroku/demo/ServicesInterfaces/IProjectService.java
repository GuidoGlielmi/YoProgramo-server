package com.heroku.demo.ServicesInterfaces;

import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.ProjectUrls;
import com.heroku.demo.Entities.ProjectTechnologies;

public interface IProjectService {
  public void addProject(Projects project, ProjectUrls urls, ProjectTechnologies techs);

}
