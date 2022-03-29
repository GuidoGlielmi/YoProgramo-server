package com.heroku.demo.Services;

import java.util.UUID;
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
    return expRepo.findAllByOrderByTitleAsc();
  }

  @Override
  public UUID addExperience(Experiences experience) {
    return expRepo.save(experience).getId();
  }

  @Override
  public Experiences updateExperience(Experiences experience) {
    UUID id = experience.getId();
    Experiences foundExperience = expRepo.findById(id).orElseThrow();
    foundExperience = experience;
    return expRepo.save(foundExperience);

  }

  @Override
  public List<Experiences> deleteExperience(UUID id) {
    expRepo.delete(expRepo.findById(id).orElseThrow());
    return expRepo.findAllByOrderByTitleAsc();
  }

}
