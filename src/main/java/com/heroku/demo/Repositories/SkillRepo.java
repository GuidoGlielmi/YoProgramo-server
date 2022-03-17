package com.heroku.demo.Repositories;

import java.util.List;
import java.util.UUID;
import com.heroku.demo.Entities.Skills;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepo extends JpaRepository<Skills, UUID> {
  List<Skills> findAllByOrderByTypeAscNameAsc();
}
