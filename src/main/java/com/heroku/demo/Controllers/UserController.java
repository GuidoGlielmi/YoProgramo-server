package com.heroku.demo.Controllers;

import java.util.UUID;

import com.heroku.demo.DTO.ResponseStateDto;
import com.heroku.demo.Entities.Role;
import com.heroku.demo.Entities.Users;
import com.heroku.demo.ServicesInterfaces.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.Data;

@RestController
@RequestMapping("users")
public class UserController {
  @Autowired
  private IUserService userService;

  @PostMapping("/role")
  public ResponseEntity<ResponseStateDto> addRole(@RequestBody Role role) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(userService.addRole(role).toString());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping("/role/user")
  public ResponseEntity<ResponseStateDto> addRoleToUser(@RequestBody AddRoleToUserForm roleToUser) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(userService.addRoleToUser(roleToUser.getUsername(), roleToUser.getRoleName()));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @GetMapping
  public ResponseEntity<ResponseStateDto> getUsers() {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(userService.getUsers());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PostMapping
  public ResponseEntity<ResponseStateDto> addUser(@RequestBody Users user) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(userService.addUser(user).toString());
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @PutMapping
  public ResponseEntity<ResponseStateDto> updateUser(@RequestBody Users user) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(userService.updateUser(user));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseStateDto> addUser(@PathVariable UUID id) {
    ResponseStateDto res;
    try {
      res = new ResponseStateDto(userService.deleteUser(id));
      return ResponseEntity.ok().body(res);
    } catch (Exception err) {
      res = new ResponseStateDto(500);
      return ResponseEntity.internalServerError().body(res);
    }
  }

}

@Data
class AddRoleToUserForm {
  private String username;
  private String roleName;
}