package com.heroku.demo.Repositories;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.ProjectUrl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectUrlRepo extends JpaRepository<ProjectUrl, UUID> {
  List<ProjectUrl> findAllByOrderByProjectAscUrlAsc();

}
