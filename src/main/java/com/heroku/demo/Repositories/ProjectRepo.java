package com.heroku.demo.Repositories;

import java.util.UUID;

import com.heroku.demo.Entities.Projects;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Projects, UUID> {
}
