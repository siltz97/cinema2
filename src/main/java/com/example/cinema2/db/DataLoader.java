package com.example.cinema2.db;

import com.example.cinema2.entity.FilmEntity;
import com.example.cinema2.entity.RoomEntity;
import com.example.cinema2.entity.SeatEntity;
import com.example.cinema2.repo.FilmRepository;
import com.example.cinema2.repo.RoomRepository;
import com.example.cinema2.repo.SeatRepository;
import com.example.cinema2.repo.TicketRepository;
import com.example.cinema2.utility.TicketUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SeatRepository seatRepository;


    @Override
    public void run(String... args) throws Exception {
        RoomEntity room = new RoomEntity();
        room.setName("Room1");
        room.setTotalSeats(60L);
        roomRepository.save(room);

        FilmEntity film = new FilmEntity();
        film.setName("Film1");
        film.setDuration(200L);
        film.setType3D(false);
        film.setRoom(room);

        filmRepository.save(film);

        room.setFilm(film);

        int num = 0;
        int letter= 0;
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F");
        List<SeatEntity> seats = new ArrayList<>();
        for(int i=0; i<60; i++ ){
            num++;
            SeatEntity seat = new SeatEntity();
            StringBuilder builder = new StringBuilder();
            if(i%10==0 && i!=0){
                letter++;
                num = 1;
            }
            String letterS = letters.get(letter);
            seat.setSeatNumber(String.valueOf(builder.append(letterS).append("-").append(num)));
            seat.setRoom(room);
            seat.setOccupied(false);
            seatRepository.save(seat);
            seats.add(seat);
        }
        room.setSeats(seats);
        roomRepository.save(room);
    }
}
