package com.example.cinema2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    private String hash;

    @OneToOne
    private SeatEntity seat;

   @ManyToOne
   private RoomEntity room;

    @ManyToOne
    private FilmEntity film;
}
