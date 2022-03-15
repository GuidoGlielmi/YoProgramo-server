package com.heroku.demo.ServicesInterfaces;

import com.heroku.demo.Entities.Users;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {
  public Users getUsers();

  public void addUser(Users user);

  public void updateUser(Users user, long id);

  public void deleteUser(long id);
}
