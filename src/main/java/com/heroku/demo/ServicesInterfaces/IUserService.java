package com.heroku.demo.ServicesInterfaces;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.Role;
import com.heroku.demo.Entities.Users;

import org.springframework.stereotype.Service;

@Service
public interface IUserService {

  Role addRole(Role role);

  Users addRoleToUser(String username, String roleName);

  Users getUser(String username);

  public List<Users> getUsers();

  public UUID addUser(Users user);

  public Users updateUser(Users user);

  public List<Users> deleteUser(UUID id);
}
