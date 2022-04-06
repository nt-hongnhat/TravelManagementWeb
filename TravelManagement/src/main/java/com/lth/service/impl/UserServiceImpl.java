package com.lth.service.impl;

import com.lth.pojos.User;
import com.lth.pojos.UserRole;
import com.lth.repository.UserRepository;
import com.lth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean registerUser(User user) {
        String password = user.getPassword();
        user.setPassword(this.bCryptPasswordEncoder.encode(password));
        user.setUserRole(String.valueOf(UserRole.CUSTOMER));
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
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
