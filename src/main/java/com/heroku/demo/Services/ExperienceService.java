package com.heroku.demo.Services;

import com.heroku.demo.Entities.Experiences;
import com.heroku.demo.Repositories.ExperienceRepo;
import com.heroku.demo.ServicesInterfaces.IExperiencesService;

import org.springframework.beans.factory.annotation.Autowired;

public class ExperienceService implements IExperiencesService {
  @Autowired
  ExperienceRepo expRepo;

  @Override
  public void addExperience(Experiences experience) {

  }

}
