package com.heroku.demo.Entities;

import java.util.UUID;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skills {
  @Id
  @GeneratedValue
  private UUID id;

  private String name = "";
  private int abilityPercentage = 0;
  private String type = "";

}
