package com.example.cinema2.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FilmDto {
    private String name;
    private boolean type3D;
    private Long duration;
    private LocalDateTime endTime;
}
