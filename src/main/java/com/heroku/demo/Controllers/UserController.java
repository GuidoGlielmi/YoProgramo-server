package com.heroku.demo.Controllers;

import java.util.List;
import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.Users;
import com.heroku.demo.ServicesInterfaces.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
  public ResponseStateDto addUser(@RequestBody Users user) {
    return new ResponseStateDto("User added successfully", userService.addUser(user).toString());
  }

  @PutMapping
  public ResponseStateDto updateUser(@RequestBody Users user) {
    return new ResponseStateDto("User saved successfully", userService.updateUser(user));
  }

  @DeleteMapping("/{id}")
  public ResponseStateDto addUser(@PathVariable UUID id) {
    return new ResponseStateDto("User deleted successfully", userService.deleteUser(id));
  }
}
