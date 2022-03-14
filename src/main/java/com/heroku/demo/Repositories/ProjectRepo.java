package com.heroku.demo.Repositories;

import java.util.List;

import com.heroku.demo.DTO.ProjectDto;
import com.heroku.demo.Entities.Projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepo extends JpaRepository<Projects, Long> {
  /* @Query(value = "SELECT p, techs, urls FROM Projects p INNER JOIN projects_technologies techs ON p.id = techs.project INNER JOIN ProjectUrls urls ON p.id = urls.project ORDER BY title") */
  @Query(value = "SELECT p FROM Projects p ORDER BY title")
  Object[] getProjects();

}
