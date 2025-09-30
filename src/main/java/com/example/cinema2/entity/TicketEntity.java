package com.example.cinema2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rowLetter;

    private Long columnNumber;

    @ManyToOne
    private RoomEntity room;

    @ManyToOne
    private FilmEntity film;
}
