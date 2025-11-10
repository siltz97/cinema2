package com.example.cinema2.service.impl;

import com.example.cinema2.entity.UserEntity;
import com.example.cinema2.repo.UserRepository;
import com.example.cinema2.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "users")
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    @Override
    @Cacheable(key = "#time")
    public void getUsers(Long time) {
        try{
            Thread.sleep(time);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public UserEntity addUser(UserEntity user) {
        return null;
    }

    @Override
    @CacheEvict(key = "#id")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @CachePut(key = "#user.id")
    public UserEntity updateUser(UserEntity user) {
        userRepository.save(user);
        return user;
    }
    @Override
    @Cacheable(key = "#id")
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
