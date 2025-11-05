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
import org.springframework.scheduling.annotation.Scheduled;
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

    @GetMapping("/create")
    public ResponseEntity<TicketDto> create(@RequestBody TicketDto ticket) {
        TicketEntity ticketEntity = ticketMapper.convertToEntity(ticket);
        ticketEntity = ticketService.create(ticketEntity);
        ticket = ticketMapper.convertToDto(ticketEntity);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/create/{ticketNum}/{filmName}/{roomName}")
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


    @GetMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody TicketDto ticket) {
        TicketEntity ticketEntity = ticketMapper.convertToEntity(ticket);
        ticketRepository.delete(ticketEntity);
        return ResponseEntity.ok(ticket);
    }
}
