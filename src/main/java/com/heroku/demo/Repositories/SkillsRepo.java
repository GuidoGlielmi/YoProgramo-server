package com.heroku.demo.Repositories;

import com.heroku.demo.Entities.Skills;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepo extends JpaRepository<Skills, Long> {

}
