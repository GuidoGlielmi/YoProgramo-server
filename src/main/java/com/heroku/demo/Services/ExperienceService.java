package com.heroku.demo.Services;

import java.util.List;

import com.heroku.demo.Entities.Experiences;
import com.heroku.demo.Repositories.ExperienceRepo;
import com.heroku.demo.ServicesInterfaces.IExperiencesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperiencesService {
  @Autowired
  ExperienceRepo expRepo;

  @Override
  public List<Experiences> getExperiences(Experiences experience) {
    return expRepo.findAll();
  }

  @Override
  public void addExperience(Experiences experience) {

  }

  @Override
  public void updateExperience(Experiences experience, long id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteExperience(long id) {
    expRepo.deleteById(id);
  }

}
