package com.heroku.demo.Services;

import java.util.UUID;
import java.util.List;

import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.Repositories.TechRepo;
import com.heroku.demo.ServicesInterfaces.ITechService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechService implements ITechService {

  @Autowired
  TechRepo techRepo;

  @Override
  public List<Technologies> getTechs() {
    return techRepo.findAll();
  }

  @Override
  public String addTech(Technologies tech) {
    try {
      techRepo.save(tech);
      return "Technology item added successfully";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public Technologies updateTech(Technologies tech) {
    UUID id = tech.getId();
    Technologies selectedTechnologies = techRepo.findById(id).orElseThrow();
    if (!tech.getName().isBlank()) {
      selectedTechnologies.setName(tech.getName());
    }
    if (tech.getProjects().size() != 0) {
      selectedTechnologies.setProjects(tech.getProjects());
    }
    techRepo.save(selectedTechnologies);
    return selectedTechnologies;
  }

  @Override
  public String deleteTech(UUID id) {
    techRepo.findById(id).orElseThrow();
    techRepo.deleteById(id);
    return "Technology item deleted successfully";

  }

}
