package com.heroku.demo.ServicesInterfaces;

import java.util.UUID;
import java.util.List;

import com.heroku.demo.Entities.Technologies;

public interface ITechService {
  public List<Technologies> getTechs();

  public String addTech(Technologies tech);

  public Technologies updateTech(Technologies tech);

  public String deleteTech(UUID id);

}
