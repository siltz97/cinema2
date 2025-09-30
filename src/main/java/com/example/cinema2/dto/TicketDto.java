package com.example.cinema2.dto;


import lombok.Data;

@Data
public class TicketDto {

    private String rowLetter;

    private Long columnNumber;

    private String roomName;

    private String filmName;
}
