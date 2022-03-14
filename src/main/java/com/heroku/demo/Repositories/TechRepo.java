package com.heroku.demo.Repositories;

import com.heroku.demo.Entities.Technologies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepo extends JpaRepository<Technologies, Long> {

}
