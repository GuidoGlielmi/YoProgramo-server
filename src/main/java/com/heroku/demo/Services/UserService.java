package com.heroku.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.Role;
import com.heroku.demo.Entities.Users;
import com.heroku.demo.Repositories.RoleRepo;
import com.heroku.demo.Repositories.UserRepo;
import com.heroku.demo.ServicesInterfaces.IUserService;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
// @Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService, UserDetailsService {

  private final UserRepo userRepo;
  private final RoleRepo roleRepo;
  private final PasswordEncoder passEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // UserDetailService implementation. This is used by spring security to search for users
    Users foundUser = userRepo.findByUsername(username);
    if (foundUser == null) {
      throw new UsernameNotFoundException("User not found");
    }
    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    foundUser.getRoles().forEach(role -> {
      authorities.add(new SimpleGrantedAuthority(role.getName()));
    });
    //User type of 
    return new User(foundUser.getUsername(), foundUser.getPassword(), authorities);
  }

  @Override
  public Role addRole(Role role) {
    return roleRepo.save(role);
  }

  @Override
  public Users addRoleToUser(String username, String roleName) {
    Users user = userRepo.findByUsername(username);
    Role role = roleRepo.findByName("ROLE_" + roleName);
    user.addRole(role); // because this is transactional, everything gets saved automatically
    return user;
  }

  @Override
  public Users getUser(String username) {
    return userRepo.findByUsername(username);
  }

  @Override
  public List<Users> getUsers() {
    return userRepo.findAll();
  }

  @Override
  public UUID addUser(Users user) {
    user.setPassword(passEncoder.encode(user.getPassword()));
    return userRepo.save(user).getId();
  }

  @Override
  public Users updateUser(Users user) {
    UUID id = user.getId();
    Users foundUsers = userRepo.findById(id).orElseThrow();
    /* if (!user.getFirstName().isBlank()) {
      foundUsers.setFirstName(user.getFirstName());
    }
    if (!user.getLastName().isBlank()) {
      foundUsers.setLastName(user.getLastName());
    }
    if (!user.getEmail().isBlank()) {
      foundUsers.setEmail(user.getEmail());
    }
    if (!user.getGithubUrl().isBlank()) {
      foundUsers.setGithubUrl(user.getGithubUrl());
    }
    if (!user.getLinkedInUrl().isBlank()) {
      foundUsers.setLinkedInUrl(user.getLinkedInUrl());
    }
    if (!user.getAboutMe().isBlank()) {
      foundUsers.setAboutMe(user.getAboutMe());
    } */
    return userRepo.save(foundUsers);
  }

  @Override
  public List<Users> deleteUser(UUID id) {
    userRepo.delete(userRepo.findById(id).orElseThrow());
    return userRepo.findAll();
  }

}
