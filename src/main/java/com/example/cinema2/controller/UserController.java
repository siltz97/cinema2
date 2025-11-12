package com.example.cinema2.controller;

import com.example.cinema2.caching.CacheInspector;
import com.example.cinema2.entity.UserEntity;
import com.example.cinema2.repo.UserRepository;
import com.example.cinema2.service.impl.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UsersServiceImpl userService;
    private final CacheInspector cacheInspector;

    @GetMapping("/get")
    public void cacheVerification() {
        userService.getUsers(10000L);
    }

    @PutMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/getById")
    public ResponseEntity<UserEntity> getUserById(@RequestParam Long id) {
        UserEntity user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/cache")
    public void cache() {
       cacheInspector.printCacheContent();
        System.out.println("---------");
       cacheInspector.debugCache();
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,@RequestParam String password) {
        userService.login(username, password);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
