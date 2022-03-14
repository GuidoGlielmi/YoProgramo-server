package com.heroku.demo.Repositories;

import com.heroku.demo.Entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
}
