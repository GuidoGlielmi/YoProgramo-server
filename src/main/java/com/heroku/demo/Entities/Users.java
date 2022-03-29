package com.heroku.demo.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
  @Id
  @GeneratedValue
  private UUID id;
  private String username = "";
  private String password = "";
  private String firstName = "";
  private String lastName = "";
  private String linkedInUrl = "";
  private String githubUrl = "";
  private String aboutMe = "";
  private String profileImg = "";
  /*
  DEFAULTS:
  OneToMany: LAZY
  ManyToOne: EAGER
  ManyToMany: LAZY
  OneToOne: EAGER
  */
  @ManyToMany(fetch = FetchType.EAGER)
  List<Role> roles = new ArrayList<Role>();

  public void addRole(Role role) {
    this.roles.add(role);
  }
}
