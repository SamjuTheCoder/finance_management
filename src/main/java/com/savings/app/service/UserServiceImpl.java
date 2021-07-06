package com.savings.app.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.savings.app.models.User;
import com.savings.app.repository.UserRepository;

@Service("userService") 
public class UserServiceImpl implements UserService {
 
 @Autowired
 private UserRepository userRepository;
 
 @Override
 public User findUserByEmail(String email) {
  return userRepository.findByEmail(email);
 }

}
