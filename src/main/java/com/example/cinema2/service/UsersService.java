package com.example.cinema2.service;


import com.example.cinema2.entity.UserEntity;

public interface UsersService {
    void getUsers(Long time);
    UserEntity addUser(UserEntity user);
    void deleteUser(Long id);
    boolean updateUser(UserEntity user);
    UserEntity getUserById(Long id);

}
