package com.heroku.demo.Services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
  String SECRET = "secret";

  public JwtAuthorizationFilter(AuthenticationManager authManager) {
    super(authManager);
  }

  @Override
  //intercepts the requests
  protected void doFilterInternal(HttpServletRequest req,
      HttpServletResponse res,
      FilterChain chain) throws IOException, ServletException {

    String accessTokenHeader = req.getHeader("Authorization");

    if (accessTokenHeader == null || !accessTokenHeader.startsWith("Bearer ")) {
      chain.doFilter(req, res);
      return;
    }
    UsernamePasswordAuthenticationToken authentication = getAuthentication(req, accessTokenHeader);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(req, res);
  }

  // Reads the JWT from the Authorization header, and then uses JWT to validate the token
  private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request, String token) {
    // verifies the token and returns the username
    Verification algo = JWT.require(Algorithm.HMAC512(SECRET));
    JWTVerifier verifier = algo.build();
    DecodedJWT decodedToken = verifier.verify(token.replace("Bearer ", ""));
    String username = decodedToken.getSubject();
    String[] roles = decodedToken.getClaim("roles").asArray(String.class);
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    Arrays.stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

    if (username != null) {
      return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

    return null;
  }
}