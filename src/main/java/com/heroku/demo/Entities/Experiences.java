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
public class Experiences {
  @Id
  @GeneratedValue
  private UUID id;
  private String title = "";
  private String description = "";
  private String startDate = "";
  private String endDate = "";
  private String certificate = "";
  private String experienceImg = "";

}
