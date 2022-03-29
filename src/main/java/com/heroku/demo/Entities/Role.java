package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Role {
  @Id
  @GeneratedValue
  UUID id;
  String name;

  public Role(UUID id, String name) {
    this.id = id;
    this.name = "ROLE_" + name;
  }

}
