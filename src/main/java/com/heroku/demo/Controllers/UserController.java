package com.heroku.demo.Controllers;

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
  public void addUser(Users user) {
    userService.addUser(user);
  }

  @PutMapping
  public void updateUser(@RequestBody Users user, @PathVariable long id) {
    userService.updateUser(user, id);
  }

  @DeleteMapping
  public void addUser(@PathVariable long id) {
    userService.deleteUser(id);
  }
}
