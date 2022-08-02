package com.heroku.demo.Services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.heroku.demo.DTO.ResponseStateDto;

public class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception)
      throws IOException, ServletException {
    System.out.println(238947293);
    response.setStatus(401);
    response.setContentType("application/json");
    response.getWriter().append(new ResponseStateDto(401).toString());
  }
}
