package com.example.cinema2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long totalSeats;

    @OneToOne
    private FilmEntity film;

    @OneToMany
    private List<TicketEntity> tickets;

}
