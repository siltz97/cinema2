package com.example.cinema2.controller.security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityControllerUser {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
