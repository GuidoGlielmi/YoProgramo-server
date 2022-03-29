package com.heroku.demo.Configuration.Security;

import java.util.Arrays;

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
    /* // configuration for stateless sessions with tokenss
    http.csrf().disable(); // cross site request forgery
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    // http.authorizeRequests().anyRequest().permitAll(); //everyone have access
    // http.authorizeRequests().anyRequest(HttpMethod.GET, "**").hasAnyAuthority("");
    http.authorizeRequests().antMatchers(HttpMethod.POST).hasRole("ADMIN");
    http.addFilter(new JwtAuthenticationFilter(authenticationManagerBean()));// filter for accessing the page */
    http.csrf().disable();
    http.cors().and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().authorizeRequests()
        // the most restrictive rules are defined first
        .antMatchers(HttpMethod.GET).permitAll() // ALL GET reqs
        .antMatchers(HttpMethod.POST, "/login").permitAll() // all POST reqs from /login
        // .anyRequest().authenticated() // any authenticated req
        .anyRequest().hasRole("ADMIN") // any ADMIN (same as .hasAuthority("ROLE_ADMIN"))
        // Without an admin role the filters doesn't event get called
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationManager())) // this replaces authenticationManagerBean()
        .addFilter(new JwtAuthorizationFilter(authenticationManager()));
    // disables session creation on Spring Security

  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /* auth.inMemoryAuthentication()
                .withUser("guido")
                .password("password")
                .roles("admin_role")
                 */
    auth.userDetailsService(userDetailsService).passwordEncoder(passEncoder);
    // we are using the implementation of userDetailsService, the UserService class. 
  }

  /*   @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
   */

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(Arrays.asList("*"));
    configuration.setExposedHeaders(Arrays.asList("Authorization"));
    /* a “simple request” is one that meets all the following conditions: 
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
