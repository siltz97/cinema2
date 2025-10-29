package com.example.cinema2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long totalSeats;

    @OneToMany
    private List<SeatEntity> seats;

    @OneToOne
    private FilmEntity film;

    @OneToMany
    private List<TicketEntity> tickets;

}
