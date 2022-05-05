package com.lth.service;

import com.lth.pojos.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean registerUser(User user);
    List<User> getUser(String username);
    User findUserById(long userId);
}
