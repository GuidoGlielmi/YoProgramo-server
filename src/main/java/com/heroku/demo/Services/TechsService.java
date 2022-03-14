package com.heroku.demo.Services;

import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.Repositories.TechsRepo;
import com.heroku.demo.ServicesInterfaces.ITechsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechsService implements ITechsService {

  @Autowired
  TechsRepo techRepo;

  @Override
  public void addTech(Technologies tech) {
    techRepo.save(tech);
  }

}
