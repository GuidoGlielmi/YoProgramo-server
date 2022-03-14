package com.heroku.demo.Controllers;

import com.heroku.demo.Entities.Users;
import com.heroku.demo.ServicesInterfaces.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  @Autowired
  private IUserService userService;

  @GetMapping("/projects")
  public void addUser() {
    /* userService.addUser(new Users(0, "Guido", "Glielmi", "guidoglielmi@gmail.com", "asdasd", "asdasd", "asdasd")); */
  }

}
