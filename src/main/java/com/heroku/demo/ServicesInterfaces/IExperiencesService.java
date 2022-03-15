package com.heroku.demo.ServicesInterfaces;

import java.util.UUID;
import java.util.List;

import com.heroku.demo.Entities.Experiences;

public interface IExperiencesService {
  public List<Experiences> getExperiences(Experiences experience);

  public String addExperience(Experiences experience);

  public Experiences updateExperience(Experiences experience);

  public String deleteExperience(UUID id);

}
