package com.heroku.demo.Services;

import com.heroku.demo.ServicesInterfaces.IEducationService;
import com.heroku.demo.Entities.Education;
import com.heroku.demo.Repositories.EducationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {
  @Autowired
  EducationRepo educationRepo;

  @Override
  public void addEducation(Education education) {
    educationRepo.save(education);
  }
}
