package com.heroku.demo.Services;

import java.util.List;

import com.heroku.demo.DTO.ProjectDto;
import com.heroku.demo.Entities.*;
import com.heroku.demo.Repositories.*;
import com.heroku.demo.ServicesInterfaces.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
  @Autowired
  UserRepository userRepo;
  @Autowired
  ProjectRepo projectRepo;

  @Override
  public Users getUser() {
    return userRepo.findAll().get(0);
  }

  @Override
  public void addUser(Users user) {
    userRepo.save(user);
  }
  /* 
  @Override
  public void addProject(Projects project, ProjectTechnologies techs, ProjectUrls urls) {
  
  }
  
  @Override
  public void addTechnology(Projects project, ProjectTechnologies techs, ProjectUrls urls) {
  
  }
  
  @Override
  public void addProjectUrl(Projects project, ProjectTechnologies techs, ProjectUrls urls) {
  
  }
  
  @Override
  public Object[] getProjects() {
     List<Projects> projects = projectRepo.findAll();
    List<ProjectTechnologies> technologies = projectTechnologiesRepo.findAll();
    List<ProjectUrls> urls = projectUrlsRepo.findAll();
    
    return projectRepo.getProjects();
  }
  
  @Override
  public List<Experiences> getExperiences() {
    return null;
  }
  
  @Override
  public List<Education> getEducation() {
    return null;
  }
  
  @Override
  public List<Skills> getSkills() {
    return null;
  }
   */
}
