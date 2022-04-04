package com.lth.service.impl;

import com.lth.pojos.User;
import com.lth.repository.UserRepository;
import com.lth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean registerUser(User user) {
        return userRepository.registerUser(user);
    }

    @Override
    public List<User> getUser(String username) {
        return userRepository.getUser(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUser(username);
        if (users.isEmpty())
            throw new UsernameNotFoundException("Tài khoản không khả dụng!");

        User user = users.get(0);
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(user.getUserRole()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                                                                    user.getPassword(), auth);
    }
}
