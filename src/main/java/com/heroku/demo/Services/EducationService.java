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
  public Education addEducation(Education education) {
    return educationRepo.save(education);
  }

  @Override
  public Education updateEducation(Education education) {
    UUID id = education.getId();
    Education selectedEducation = educationRepo.findById(id).orElseThrow();
    if (!education.getSchool().isBlank()) {
      selectedEducation.setSchool(education.getSchool());
    }
    if (!education.getStartDate().isBlank()) {
      selectedEducation.setStartDate(education.getStartDate());
    }
    if (!education.getEndDate().isBlank()) {
      selectedEducation.setEndDate(education.getEndDate());
    }
    if (!education.getDegree().isBlank()) {
      selectedEducation.setDegree(education.getDegree());
    }
    educationRepo.save(selectedEducation);
    return selectedEducation;
  }

  @Override
  public String deleteEducation(UUID id) {
    educationRepo.findById(id).orElseThrow();
    educationRepo.deleteById(id);
    return "Education item deleted successfully";
  }

}
