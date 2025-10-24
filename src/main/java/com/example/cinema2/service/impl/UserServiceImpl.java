package com.example.cinema2.service.impl;

import com.example.cinema2.entity.UserEntity;
import com.example.cinema2.repo.UserRepository;
import com.example.cinema2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        List<SimpleGrantedAuthority> roles = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole())).toList();
        return new User(user.getUsername(),
                user.getPassword(),
                roles);
    }
}
