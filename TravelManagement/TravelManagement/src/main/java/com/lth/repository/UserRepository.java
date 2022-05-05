package com.lth.repository;

import com.lth.pojos.User;

import java.util.List;

public interface UserRepository {
    boolean registerUser(User user);
    List<User> getUser(String username);
    User findUserById(long userId);
}
