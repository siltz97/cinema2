package com.example.cinema2.service.impl;

import com.example.cinema2.caching.CacheInspector;
import com.example.cinema2.entity.UserEntity;
import com.example.cinema2.repo.UserRepository;
import com.example.cinema2.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "users")
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final CacheInspector cacheInspector;

    @Override
    @Cacheable(key = "#time")
    public void getUsers(Long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
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
    @CachePut(key = "#user.username +' _ '+ #user.password")
    public boolean updateUser(UserEntity user) {
        userRepository.save(user);
       //cacheInspector.addCacheContent(user.getId(),user,"users");
        return true;
    }

    @Override
    @Cacheable(key = "#id")
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Cacheable(key = "#username +' _ '+ #password")
    public boolean login(String username, String password) {
        List<UserEntity> possibleUsers = userRepository.findAll();
        boolean hasAccess = (possibleUsers.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password)));
        if (hasAccess) {
            System.out.println("you have been logged from DB");
            return true;
        } else {
            System.out.println("Access denied");
            return false;
        }
    }


}
