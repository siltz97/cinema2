package com.example.cinema2.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean type3D;

    private Long duration;

    private LocalDateTime endTime;

    @OneToOne
    private RoomEntity room;

    @OneToMany
    private List<TicketEntity> tickets;
}
