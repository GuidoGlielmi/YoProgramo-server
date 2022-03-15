package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.*;

@Entity
public class Users {
  @Id
  @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String firstName = "";
  private String lastName = "";
  private String email = "";
  private String linkedInUrl = "";
  private String githubUrl = "";
  private String aboutMe = "";

  public Users(UUID id, String firstName, String lastName, String email, String linkedInUrl, String githubUrl,
      String aboutMe) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.linkedInUrl = linkedInUrl;
    this.githubUrl = githubUrl;
    this.aboutMe = aboutMe;
  }

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLinkedInUrl() {
    return this.linkedInUrl;
  }

  public void setLinkedInUrl(String linkedInUrl) {
    this.linkedInUrl = linkedInUrl;
  }

  public String getGithubUrl() {
    return this.githubUrl;
  }

  public void setGithubUrl(String GithubUrl) {
    this.githubUrl = GithubUrl;
  }

  public String getAboutMe() {
    return this.aboutMe;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

}
