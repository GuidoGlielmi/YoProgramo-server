package com.heroku.demo.Services;

import com.heroku.demo.ServicesInterfaces.IEducationService;

import java.util.UUID;
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
  public List<Education> addEducation(Education education) {
    educationRepo.save(education);
    return educationRepo.findAll();
  }

  @Override
  public Education updateEducation(Education education) {
    UUID id = education.getId();
    Education foundEducation = educationRepo.findById(id).orElseThrow();
    if (!education.getSchool().isBlank()) {
      foundEducation.setSchool(education.getSchool());
    }
    if (!education.getStartDate().isBlank()) {
      foundEducation.setStartDate(education.getStartDate());
    }
    if (!education.getEndDate().isBlank()) {
      foundEducation.setEndDate(education.getEndDate());
    }
    if (!education.getDegree().isBlank()) {
      foundEducation.setDegree(education.getDegree());
    }
    return educationRepo.save(foundEducation);
  }

  @Override
  public List<Education> deleteEducation(UUID id) {
    educationRepo.delete(educationRepo.findById(id).orElseThrow());
    return educationRepo.findAll();
  }

}
