package com.example.cinema2.service.impl;

import com.example.cinema2.entity.TicketEntity;
import com.example.cinema2.repo.TicketRepository;
import com.example.cinema2.service.TicketService;
import com.example.cinema2.utility.TicketUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TicketServiceImpl implements TicketService {

    TicketUtility ticketUtility = new TicketUtility();

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public TicketEntity create(TicketEntity ticket) {
        ticket.setHash(ticketUtility.createHash());
        return ticketRepository.save(ticket);
    }

}
