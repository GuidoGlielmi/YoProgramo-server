package com.heroku.demo.Repositories;

import java.util.UUID;

import com.heroku.demo.Entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, UUID> {
  Role findByName(String name);
}