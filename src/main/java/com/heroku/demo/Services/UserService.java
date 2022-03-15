package com.heroku.demo.Services;

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
  public Users getUsers() {
    return userRepo.findAll().get(0);
  }

  @Override
  public String addUser(Users user) {
    try {
      userRepo.save(user);
      return "User added successfully";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public Users updateUser(Users user) {
    UUID id = user.getId();
    Users selectedUsers = userRepo.findById(id).orElseThrow();
    if (!user.getFirstName().isBlank()) {
      selectedUsers.setFirstName(user.getFirstName());
    }
    if (!user.getLastName().isBlank()) {
      selectedUsers.setLastName(user.getLastName());
    }
    if (!user.getEmail().isBlank()) {
      selectedUsers.setEmail(user.getEmail());
    }
    if (!user.getGithubUrl().isBlank()) {
      selectedUsers.setGithubUrl(user.getGithubUrl());
    }
    if (!user.getLinkedInUrl().isBlank()) {
      selectedUsers.setLinkedInUrl(user.getLinkedInUrl());
    }
    if (!user.getAboutMe().isBlank()) {
      selectedUsers.setAboutMe(user.getAboutMe());
    }
    userRepo.save(selectedUsers);
    return selectedUsers;
  }

  @Override
  public String deleteUser(UUID id) {
    userRepo.findById(id).orElseThrow();
    userRepo.deleteById(id);
    return "User deleted successfully";
  }
}
