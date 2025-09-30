package com.example.cinema2.db;

import com.example.cinema2.entity.FilmEntity;
import com.example.cinema2.entity.RoomEntity;
import com.example.cinema2.repo.FilmRepository;
import com.example.cinema2.repo.RoomRepository;
import com.example.cinema2.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public void run(String... args) throws Exception {
        RoomEntity room = new RoomEntity();
        room.setName("Room 1");
        room.setTotalSeats(60L);
        roomRepository.save(room);

        FilmEntity film = new FilmEntity();
        film.setName("Film 1");
        film.setDuration(200L);
        film.setType3D(false);
        film.setRoom(room);

        filmRepository.save(film);

        room.setFilm(film);
        roomRepository.save(room);


    }
}
