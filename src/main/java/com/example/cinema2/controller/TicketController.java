package com.example.cinema2.controller;


import com.example.cinema2.dto.TicketDto;
import com.example.cinema2.entity.TicketEntity;
import com.example.cinema2.mapper.TicketMapper;
import com.example.cinema2.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketServiceImpl ticketService;
    @Autowired
    private TicketMapper ticketMapper;

    @PostMapping
    public ResponseEntity<TicketDto> create(@RequestBody TicketDto ticket) {
        TicketEntity ticketEntity = ticketMapper.convertToEntity(ticket);
        ticketEntity = ticketService.create(ticketEntity);
        ticket = ticketMapper.convertToDto(ticketEntity);
        return ResponseEntity.ok(ticket);

    }
}
