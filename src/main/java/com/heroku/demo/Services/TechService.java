package com.heroku.demo.Services;

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
  public void addTech(Technologies tech) {
    techRepo.save(tech);
  }

}
