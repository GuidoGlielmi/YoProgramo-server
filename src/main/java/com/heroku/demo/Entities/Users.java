package com.heroku.demo.Entities;

import javax.persistence.*;

@Entity
public class Users {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String firstName;
  private String lastName;
  private String email;
  private String linkedInUrl;
  private String GithubUrl;
  private String aboutMe;

  public long getid() {
    return this.id;
  }

  public void setid(long id) {
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
    return this.GithubUrl;
  }

  public void setGithubUrl(String GithubUrl) {
    this.GithubUrl = GithubUrl;
  }

  public String getAboutMe() {
    return this.aboutMe;
  }

  public void setAboutMe(String aboutMe) {
    this.aboutMe = aboutMe;
  }

}
