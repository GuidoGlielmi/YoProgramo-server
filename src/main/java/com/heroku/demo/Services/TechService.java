package com.heroku.demo.Services;

import java.util.UUID;
import java.util.List;

import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.Repositories.ProjectRepo;
import com.heroku.demo.Repositories.TechRepo;
import com.heroku.demo.ServicesInterfaces.ITechService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechService implements ITechService {

  @Autowired
  TechRepo techRepo;
  @Autowired
  ProjectRepo projectRepo;

  @Override
  public List<Technologies> getTechs() {
    return techRepo.findAllByOrderByNameAsc();
  }

  @Override
  public List<Technologies> addTech(Technologies tech) {
    techRepo.save(tech);
    return techRepo.findAllByOrderByNameAsc();
  }

  @Override
  public Technologies updateTech(Technologies tech) {
    UUID id = tech.getId();
    Technologies foundTechnologies = techRepo.findById(id).orElseThrow();
    if (!tech.getName().isBlank()) {
      foundTechnologies.setName(tech.getName());
    }
    if (tech.getProjects().size() != 0) {
      foundTechnologies.setProjects(tech.getProjects());
    }
    return techRepo.save(foundTechnologies);
  }

  @Override
  public List<Technologies> deleteTech(UUID id) {
    Technologies foundTech = techRepo.findById(id).orElseThrow();
    for (Projects projects : foundTech.getProjects()) {
      projects.getTechs().remove(foundTech);
    }
    techRepo.delete(foundTech);
    return techRepo.findAllByOrderByNameAsc();
  }

}
