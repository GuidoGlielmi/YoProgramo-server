package com.heroku.demo.Controllers;

import java.util.UUID;

import com.heroku.demo.Entities.Users;
import com.heroku.demo.ServicesInterfaces.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
  @Autowired
  private IUserService userService;

  @GetMapping
  public Users getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public String addUser(Users user) {
    return userService.addUser(user);
  }

  @PutMapping
  public void updateUser(@RequestBody Users user) {
    userService.updateUser(user);
  }

  @DeleteMapping
  public void addUser(@PathVariable UUID id) {
    userService.deleteUser(id);
  }
}
