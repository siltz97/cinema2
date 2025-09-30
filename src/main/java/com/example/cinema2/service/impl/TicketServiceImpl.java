package com.example.cinema2.service.impl;

import com.example.cinema2.entity.TicketEntity;
import com.example.cinema2.repo.TicketRepository;
import com.example.cinema2.service.TicketService;
import org.springframework.stereotype.Service;


@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    @Override
    public TicketEntity create(TicketEntity ticket) {
        return ticketRepository.save(ticket);
    }
}
