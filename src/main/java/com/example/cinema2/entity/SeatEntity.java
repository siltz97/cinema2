package com.example.cinema2.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    private boolean occupied = false;

    @ManyToOne
    private RoomEntity room;

    @OneToOne
    private TicketEntity ticket;

}
