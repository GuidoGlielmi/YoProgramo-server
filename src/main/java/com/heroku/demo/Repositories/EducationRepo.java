package com.heroku.demo.Repositories;

import com.heroku.demo.Entities.Education;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education, Long> {

}
