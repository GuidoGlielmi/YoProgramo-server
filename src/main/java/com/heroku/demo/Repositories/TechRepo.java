package com.heroku.demo.Repositories;

import java.util.UUID;
import com.heroku.demo.Entities.Technologies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepo extends JpaRepository<Technologies, UUID> {

}
