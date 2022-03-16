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
    return expRepo.findAll();
  }

  @Override
  public Experiences addExperience(Experiences experience) {
    return expRepo.save(experience);
  }

  @Override
  public Experiences updateExperience(Experiences experience) {
    UUID id = experience.getId();
    Experiences selectedExperience = expRepo.findById(id).orElseThrow();
    if (!experience.getTitle().isBlank()) {
      selectedExperience.setTitle(experience.getTitle());
    }
    if (!experience.getStartDate().isBlank()) {
      selectedExperience.setStartDate(experience.getStartDate());
    }
    if (!experience.getEndDate().isBlank()) {
      selectedExperience.setEndDate(experience.getEndDate());
    }
    if (!experience.getDescription().isBlank()) {
      selectedExperience.setDescription(experience.getDescription());
    }
    expRepo.save(selectedExperience);
    return selectedExperience;

  }

  @Override
  public String deleteExperience(UUID id) {
    expRepo.findById(id).orElseThrow();
    expRepo.deleteById(id);
    return "Experience item deleted successfully";
  }

}
