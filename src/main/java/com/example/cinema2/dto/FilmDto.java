package com.example.cinema2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmDto {
    private String name;
    private boolean type3D;
    private Long duration;
}
