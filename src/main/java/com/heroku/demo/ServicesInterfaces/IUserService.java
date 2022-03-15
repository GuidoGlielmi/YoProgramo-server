package com.heroku.demo.ServicesInterfaces;

import java.util.UUID;
import com.heroku.demo.Entities.Users;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {
  public Users getUsers();

  public String addUser(Users user);

  public Users updateUser(Users user);

  public String deleteUser(UUID id);
}
