package com.heroku.demo.ServicesInterfaces;

import java.util.List;

import com.heroku.demo.DTO.ProjectDto;
import com.heroku.demo.Entities.*;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {
  public Users getUser();

  public void addUser(Users user);

  /*   public void addProject(Projects project, ProjectTechnologies techs, ProjectUrls urls);
  
  public void addTechnology(Projects project, ProjectTechnologies techs, ProjectUrls urls);
  
  public void addProjectUrl(Projects project, ProjectTechnologies techs, ProjectUrls urls);
  
  public Object[] getProjects();
  
  public List<Experiences> getExperiences();
  
  public List<Education> getEducation();
  
  public List<Skills> getSkills(); */
}
