package com.heroku.demo.Services;

import java.util.List;
import java.util.UUID;
import com.heroku.demo.Entities.Users;
import com.heroku.demo.Repositories.UserRepo;
import com.heroku.demo.ServicesInterfaces.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
  @Autowired
  UserRepo userRepo;

  @Override
  public List<Users> getUsers() {
    return userRepo.findAll();
  }

  @Override
  public Users addUser(Users user) {
    return userRepo.save(user);
  }

  @Override
  public Users updateUser(Users user) {
    UUID id = user.getId();
    Users foundUsers = userRepo.findById(id).orElseThrow();
    if (!user.getFirstName().isBlank()) {
      foundUsers.setFirstName(user.getFirstName());
    }
    if (!user.getLastName().isBlank()) {
      foundUsers.setLastName(user.getLastName());
    }
    if (!user.getEmail().isBlank()) {
      foundUsers.setEmail(user.getEmail());
    }
    if (!user.getGithubUrl().isBlank()) {
      foundUsers.setGithubUrl(user.getGithubUrl());
    }
    if (!user.getLinkedInUrl().isBlank()) {
      foundUsers.setLinkedInUrl(user.getLinkedInUrl());
    }
    if (!user.getAboutMe().isBlank()) {
      foundUsers.setAboutMe(user.getAboutMe());
    }
    return userRepo.save(foundUsers);
  }

  @Override
  public List<Users> deleteUser(UUID id) {
    userRepo.delete(userRepo.findById(id).orElseThrow());
    return userRepo.findAll();
  }
}
