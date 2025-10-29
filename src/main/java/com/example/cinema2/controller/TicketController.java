package com.example.cinema2.controller;


import com.example.cinema2.dto.FilmDto;
import com.example.cinema2.dto.FilmRoomDto;
import com.example.cinema2.dto.RoomDto;
import com.example.cinema2.dto.TicketDto;
import com.example.cinema2.entity.FilmEntity;
import com.example.cinema2.entity.RoomEntity;
import com.example.cinema2.entity.SeatEntity;
import com.example.cinema2.entity.TicketEntity;
import com.example.cinema2.mapper.FilmMapper;
import com.example.cinema2.mapper.RoomMapper;
import com.example.cinema2.mapper.TicketMapper;
import com.example.cinema2.repo.FilmRepository;
import com.example.cinema2.repo.RoomRepository;
import com.example.cinema2.repo.SeatRepository;
import com.example.cinema2.repo.TicketRepository;
import com.example.cinema2.service.impl.FilmServiceImpl;
import com.example.cinema2.service.impl.RoomServiceImpl;
import com.example.cinema2.service.impl.TicketServiceImpl;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketService;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private FilmServiceImpl filmServiceImpl;
    @Autowired
    private RoomServiceImpl roomServiceImpl;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/create")
    public ResponseEntity<TicketDto> create(@RequestBody TicketDto ticket) {
        TicketEntity ticketEntity = ticketMapper.convertToEntity(ticket);
        ticketEntity = ticketService.create(ticketEntity);
        ticket = ticketMapper.convertToDto(ticketEntity);
        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/create/{ticketNum}/{filmName}/{roomName}")
    @Transactional
    public ResponseEntity<List<TicketDto>> create(@PathVariable Long ticketNum,
                                                  @PathVariable String filmName,
                                                  @PathVariable String roomName
    ) {
        List<TicketDto> tickets = new ArrayList<>();
        List<FilmEntity> filmEntity = List.of(filmRepository.getByName(filmName));
        FilmEntity film = filmEntity.stream().filter(f -> f.getRoom().getName().equals(roomName)).findFirst().get();
        List<SeatEntity> seats = seatRepository.findAllByOccupiedFalseAndRoom_Name(film.getRoom().getName());
        if (film.getRoom().getSeats().stream().filter(s -> !s.isOccupied()).count() >= ticketNum) {
            for (int i = 0; i < ticketNum; i++) {
                TicketEntity ticketEntity = new TicketEntity();
                TicketEntity savedTicket;
                ticketEntity.setFilm(film);
                ticketEntity.setRoom(film.getRoom());
                ticketEntity.setSeat(seats.stream().findFirst().get());
                savedTicket = ticketService.create(ticketEntity);
                TicketDto ticket = ticketMapper.convertToDto(savedTicket);
                tickets.add(ticket);
            }
            return ResponseEntity.ok(tickets);
        }
        throw new IllegalArgumentException("non ci sono abbastanza posti!");
    }


    @PostMapping("/creation")
    public ResponseEntity<?> createRoomAndFilm(@RequestBody FilmRoomDto dto) {
        try {
            StackCustom stackCustom = new StackCustom();
            StackCustom stackCustom2 = new StackCustom();
            StackCustom stackCustom3 = new StackCustom();
            StackCustom stackCustom4 = new StackCustom();

            ConcurrentLinkedDeque<StackCustom> deque = new ConcurrentLinkedDeque<>();

            FilmEntity filmEntity1 = new FilmEntity();
            FilmEntity filmEntity2 = new FilmEntity();
            FilmEntity filmEntity3 = new FilmEntity();
            FilmEntity filmEntity4 = new FilmEntity();

            FilmDto film = dto.getFilm();
            FilmEntity filmEntity = filmMapper.convertToEntity(film);
            RoomDto room = dto.getRoom();
            RoomEntity roomEntity = roomMapper.convertToEntity(room);

            filmEntity1.setName("film.getName()");
            filmEntity1.setDuration(11L);
            filmEntity1.setType3D(false);
            FilmEntity saved1 = filmRepository.save(filmEntity1);
            stackCustom.setOperation("save");
            stackCustom.setObject(saved1);
            deque.push(stackCustom);

            filmEntity2.setName("film.getName");
            filmEntity2.setDuration(12L);
            filmEntity2.setType3D(true);
            FilmEntity saved2 = filmRepository.save(filmEntity2);
            stackCustom2.setOperation("save1");
            stackCustom2.setObject(saved2);
            deque.push(stackCustom2);

            filmEntity3.setName("film.getNamefy");
            filmEntity3.setDuration(13L);
            filmEntity3.setType3D(false);
            FilmEntity saved3 = filmRepository.save(filmEntity3);
            stackCustom3.setOperation("save2");
            stackCustom3.setObject(saved3);
            deque.push(stackCustom3);

            filmEntity4.setName("film.getNam");
            filmEntity4.setDuration(14L);
            filmEntity4.setType3D(false);
            FilmEntity saved4 = filmRepository.save(filmEntity4);
            stackCustom4.setOperation("save3");
            stackCustom4.setObject(saved4);
            deque.push(stackCustom4);

            filmServiceImpl.save(filmEntity);
            roomServiceImpl.save(roomEntity);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(dto);
    }



}
@Data
@NoArgsConstructor
class StackCustom<T> {
    private String operation;
    private T object;
}
