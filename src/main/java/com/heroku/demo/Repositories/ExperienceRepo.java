package com.heroku.demo.Repositories;

import java.util.List;
import java.util.UUID;
import com.heroku.demo.Entities.Experiences;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepo extends JpaRepository<Experiences, UUID> {
  List<Experiences> findAllByOrderByTitleAsc();

}
