package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUrl {
  @Id
  @GeneratedValue
  private UUID id;
  @NonNull
  private String url;
  private String name;
  @ManyToOne(fetch = FetchType.LAZY) // with just @ManyToOne the corresponding table is created but urls are not included in the projects themselves
  @JsonIgnore
  private Projects project;

  @JsonInclude()
  @Transient
  private UUID projectId;

  // Every function starting with "get" gets included when calling findAll()
  public UUID getProjectId() {
    return project != null ? project.getId() : projectId;
  }
}
