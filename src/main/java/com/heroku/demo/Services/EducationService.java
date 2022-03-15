package com.heroku.demo.Services;

import com.heroku.demo.ServicesInterfaces.IEducationService;

import java.util.List;

import com.heroku.demo.Entities.Education;
import com.heroku.demo.Repositories.EducationRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {
  @Autowired
  EducationRepo educationRepo;

  @Override
  public List<Education> getEducation() {
    return educationRepo.findAll();
  }

  @Override
  public void addEducation(Education education) {
    educationRepo.save(education);
  }

  @Override
  public void updateEducation(Education education, long id) {
    // TODO Auto-generated method stub
  }

  @Override
  public void deleteEducation(long id) {
    educationRepo.deleteById(id);
  }

}
