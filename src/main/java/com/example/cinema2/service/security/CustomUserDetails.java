//package com.example.cinema2.service.security;
//
//import com.example.cinema2.entity.UserEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class CustomUserDetails implements UserDetails {
//
//    private UserEntity user;
//
//    public CustomUserDetails(UserEntity user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.addAll(user.getRoles().stream()
//                .map(role->new SimpleGrantedAuthority("ROLE_" + role.getRole()))
//                .toList());
//        authorities.addAll(user.getAuthorities().stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getAuthName()))
//                .toList());
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUsername();
//    }
//}
