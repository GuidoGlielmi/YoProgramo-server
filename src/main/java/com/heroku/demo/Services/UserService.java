package com.heroku.demo.Services;

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
  public void addUser(Users user) {
    userRepo.save(user);
  }

  @Override
  public void updateUser(Users user, long id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteUser(long id) {
    userRepo.deleteById(id);

  }
}
