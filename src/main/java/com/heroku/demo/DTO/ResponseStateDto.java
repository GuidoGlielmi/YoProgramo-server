package com.heroku.demo.DTO;

public class ResponseStateDto {
  private Object data = "";
  private String msg;

  public ResponseStateDto(String msg, Object data) {
    this.data = data;
    this.msg = msg;
  }

  public ResponseStateDto(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return this.data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMsg() {
    return this.msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}
