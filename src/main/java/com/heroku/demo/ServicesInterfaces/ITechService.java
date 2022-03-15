package com.heroku.demo.ServicesInterfaces;

import java.util.List;

import com.heroku.demo.Entities.Technologies;

public interface ITechService {
  public List<Technologies> getTechs();

  public void addTech(Technologies tech);

  public void updateTech(Technologies tech, long id);

  public void deleteTech(long id);

}
