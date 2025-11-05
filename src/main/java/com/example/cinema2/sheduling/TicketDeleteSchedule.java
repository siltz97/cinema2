package com.example.cinema2.sheduling;

import com.example.cinema2.entity.TicketEntity;
import com.example.cinema2.repo.FilmRepository;
import com.example.cinema2.repo.TicketRepository;
import com.example.cinema2.service.impl.TicketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketDeleteSchedule {

    private final TicketRepository ticketRepository;
    private final TicketServiceImpl ticketService;

    @Scheduled(fixedRate = 60000L)
    public void deleteTicketsIfExpired(){
        List<TicketEntity> tickets = ticketService.expiredTickets();
        ticketRepository.deleteAll(tickets);
    }
}
