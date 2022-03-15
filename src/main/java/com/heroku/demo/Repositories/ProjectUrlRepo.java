package com.heroku.demo.Repositories;

import com.heroku.demo.Entities.ProjectUrl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectUrlRepo extends JpaRepository<ProjectUrl, Long> {

}
