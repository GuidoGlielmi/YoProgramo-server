package com.heroku.demo.Repositories;

import com.heroku.demo.Entities.Experiences;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepo extends JpaRepository<Experiences, Long> {

}
