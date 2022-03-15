package com.heroku.demo.Repositories;

import java.util.UUID;
import com.heroku.demo.Entities.Education;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education, UUID> {

}
