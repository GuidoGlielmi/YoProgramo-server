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
    this.authManager = authManager;
    setFilterProcessesUrl("/login"); // this is created by default
  };

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {

    try {
      /*   User creds = new ObjectMapper()
          .readValue(request.getInputStream(), User.class); */
      BufferedReader reader = request.getReader();
      Gson gson = new Gson();
      User creds = gson.fromJson(reader, User.class);
      // User -> Developers may use this class directly, subclass it, or write their own UserDetails implementation from scratch.
      System.out.println("HOLAAAA");
      return authManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              creds.getUsername(),
              creds.getPassword()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    /* String username = request.getParameter("username");
    String pass = request.getParameter("password");
    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, pass);
    return authManager.authenticate(authToken); */
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    String SECRET = "secret";
    int EXPIRATION_TIME = 900_000;
    User user = (User) authResult.getPrincipal(); // spring security user (not from the app)
    String token = JWT.create()
        .withSubject(user.getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .withClaim("roles",
            user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
        .sign(Algorithm.HMAC512(SECRET));
    /*     Map<String, String> tokens = new HashMap<>();
    tokens.put("accessToken", token); */
    response.setHeader("Authorization", token);
    response.setContentType("application/json");
    ResponseStateDto responseObject = new ResponseStateDto("Logged in successfully", "");
    new ObjectMapper().writeValue(response.getOutputStream(), responseObject);
    // new ObjectMapper().writeValue(response.getOutputStream(), tokens);

    /* User user = (User) authResult.getPrincipal(); // spring security user (not from the app)
    String ACCESS_TOKEN = JWT
        .create()
        .withSubject(user.getUsername()) //some unique info about the user
        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // one hour expiration
        .withIssuer(request.getRequestURL().toString()) //author
        .withClaim("roles",
            user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())) //passes the user's roles 
        .sign(Algorithm.HMAC256("secret"));
    String REFRESH_TOKEN = JWT.create().withSubject(user.getUsername())
        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
        .withIssuer(request.getRequestURL().toString())
        .withClaim("roles",
            user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
        .sign(Algorithm.HMAC256("secret"));
    Map<String, String> tokens = new HashMap<>();
    tokens.put("accessToken", ACCESS_TOKEN);
    tokens.put("refreshToken", REFRESH_TOKEN);
    response.setContentType("application/json");
    new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    // super.successfulAuthentication(request, response, chain, authResult); */
  }

}
