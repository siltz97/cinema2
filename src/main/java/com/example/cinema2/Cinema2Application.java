package com.example.cinema2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Cinema2Application {

    public static void main(String[] args) {
        SpringApplication.run(Cinema2Application.class, args);
    }

}
