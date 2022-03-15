package com.heroku.demo.ServicesInterfaces;

import java.util.List;

import com.heroku.demo.Entities.Education;

public interface IEducationService {
  public List<Education> getEducation();

  public void addEducation(Education education);

  public void updateEducation(Education education, long id);

  public void deleteEducation(long id);
}