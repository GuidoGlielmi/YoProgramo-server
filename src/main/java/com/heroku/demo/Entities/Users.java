package com.heroku.demo.Entities;

import java.util.UUID;

import javax.persistence.*;

@Entity
public class Users {
  @Id
  @GeneratedValue
  private UUID id;
  private String firstName = "";
  private String lastName = "";
  private String email = "";
  private String linkedInUrl = "";
  private String githubUrl = "";
  private String aboutMe = "";
  private String profileImg = "";

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

  public String getProfileImg() {
    return this.profileImg;
  }

  public void setProfileImg(String profileImg) {
    this.profileImg = profileImg;
  }

}
