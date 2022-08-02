package com.heroku.demo.Configuration.Security;

import java.util.Arrays;

import com.heroku.demo.Services.JWTAuthenticationFailureHandler;
import com.heroku.demo.Services.JwtAuthenticationFilter;
import com.heroku.demo.Services.JwtAuthorizationFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.*;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor // a form of control inversion
public class Config extends WebSecurityConfigurerAdapter {
  private final UserDetailsService userDetailsService;
  private final BCryptPasswordEncoder passEncoder;

  @Override
  // This is configurated before the app is fully loaded
  public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.cors().and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        // disables session creation on Spring Security
        .and().authorizeRequests()
        // the most restrictive rules are defined first
        .antMatchers(HttpMethod.POST, "/login").permitAll() // all POST reqs from /login
        .antMatchers(HttpMethod.GET).permitAll() // ALL GET reqs
        // .anyRequest().authenticated() // any authenticated req
        .anyRequest().hasRole("ADMIN") // any ADMIN (same as .hasAuthority("ROLE_ADMIN"))
        .and().formLogin().failureHandler(new JWTAuthenticationFailureHandler())
        // Without an admin role the filters doesn't event get called
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationManager()))
        /* The authenticationManager attempts to authenticate the passed Authentication object, returning a fully populated Authentication object (including granted authorities) if successful */
        .addFilter(new JwtAuthorizationFilter(authenticationManager()));

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /* auth.inMemoryAuthentication()
                .withUser("guido")
                .password("password")
                .roles("admin_role")
                 */
    auth.userDetailsService(userDetailsService).passwordEncoder(passEncoder);
    // the implementation of userDetailsService is the UserService class. 
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://localhost:3000",
        "https://yoprogramoapp.web.app/", "https://react-portfolio-clone.herokuapp.com"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(Arrays.asList("*"));
    configuration.setExposedHeaders(Arrays.asList("Authorization"));
    /* a “simple request” is one that meets all the following conditions:s
    One of the allowed methods: GET, HEAD, POST
    The only headers we can use:
        Accept, Accept-Language, Content-Language,
        Content-Type (with application/x-www-form-urlencoded, multipart/form-data, text/plain values)
    */
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
