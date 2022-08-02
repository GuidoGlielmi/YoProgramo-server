package com.heroku.demo.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.heroku.demo.DTO.ResponseStateDto;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private AuthenticationManager authManager;

  public JwtAuthenticationFilter(AuthenticationManager authManager) {
    this.authManager = authManager; // passed in config
    super.setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
    setFilterProcessesUrl("/login"); // this is created by default
  };

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    try {
      BufferedReader reader = request.getReader();
      Gson gson = new Gson();
      User creds = gson.fromJson(reader, User.class);
      // User -> Developers may use this class directly (from spring security), subclass it, or write their own UserDetails implementation from scratch.
      return authManager.authenticate( // returns a fully populated Authentication object
          new UsernamePasswordAuthenticationToken(
              creds.getUsername(),
              creds.getPassword()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    String SECRET = "secret";
    int EXPIRATION_TIME = 86_400_000; //one day
    User user = (User) authResult.getPrincipal();
    String token = JWT.create()
        .withSubject(user.getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .withClaim("roles",
            user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
        .sign(Algorithm.HMAC512(SECRET));
    // response.setHeader("Authorization", token);
    response.setContentType("application/json");
    ResponseStateDto responseObject = new ResponseStateDto(token);
    new ObjectMapper().writeValue(response.getOutputStream(), responseObject);
  }

}
