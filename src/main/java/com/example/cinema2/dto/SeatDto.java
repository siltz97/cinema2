package com.example.cinema2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDto {

    private String seatNumber;

    private boolean occupied;

}
