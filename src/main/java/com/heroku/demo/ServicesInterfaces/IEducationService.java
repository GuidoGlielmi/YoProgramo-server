package com.heroku.demo.ServicesInterfaces;

import java.util.UUID;
import java.util.List;

import com.heroku.demo.Entities.Education;

public interface IEducationService {
  public List<Education> getEducation();

  public Education addEducation(Education education);

  public Education updateEducation(Education education);

  public List<Education> deleteEducation(UUID id);
}