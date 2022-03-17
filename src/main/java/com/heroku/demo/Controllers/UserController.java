package com.heroku.demo.Controllers;

import java.util.List;
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
  public List<Users> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public Users addUser(@RequestBody Users user) {
    return userService.addUser(user);
  }

  @PutMapping
  public Users updateUser(@RequestBody Users user) {
    return userService.updateUser(user);
  }

  @DeleteMapping("/{id}")
  public List<Users> addUser(@PathVariable UUID id) {
    return userService.deleteUser(id);
  }
}
