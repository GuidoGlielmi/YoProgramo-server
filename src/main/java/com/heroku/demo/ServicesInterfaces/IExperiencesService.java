package com.heroku.demo.ServicesInterfaces;

import java.util.List;

import com.heroku.demo.Entities.Experiences;

public interface IExperiencesService {
  public List<Experiences> getExperiences(Experiences experience);

  public void addExperience(Experiences experience);

  public void updateExperience(Experiences experience, long id);

  public void deleteExperience(long id);

}
