package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Education {
  @Id
  @GeneratedValue
  private UUID id;

  private String school = "";
  private String startDate = "";
  private String endDate = "";
  private String degree = "";
  private String educationImg = "";

}
