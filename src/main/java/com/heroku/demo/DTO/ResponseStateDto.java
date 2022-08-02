package com.heroku.demo.DTO;

import org.springframework.http.HttpStatus;

public class ResponseStateDto {
  private Object data = null;
  private String message = HttpStatus.resolve(200).name();
  private int status = 200;

  public ResponseStateDto(Object data) {
    this.data = data;
  }

  public ResponseStateDto(int status) {
    this.message = HttpStatus.resolve(status).name();
    this.status = status;
  }

  public ResponseStateDto() {
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Object getData() {
    return this.data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String toString() {
    Object data = null;
    if (this.data != null)
      data = this.data.toString();
    return "{\"data\": " + data + ", "
        + "\"status\": " + this.status + ", "
        + "\"message\": \"" + this.message + "\"}";
  }
}
