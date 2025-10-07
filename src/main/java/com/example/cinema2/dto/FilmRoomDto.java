package com.example.cinema2.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
public class FilmRoomDto{
    private RoomDto room;
    private FilmDto film;
}
