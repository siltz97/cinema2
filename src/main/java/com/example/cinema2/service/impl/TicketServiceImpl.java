package com.example.cinema2.service.impl;

import com.example.cinema2.entity.TicketEntity;
import com.example.cinema2.repo.FilmRepository;
import com.example.cinema2.repo.TicketRepository;
import com.example.cinema2.service.TicketService;
import com.example.cinema2.utility.TicketUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    TicketUtility ticketUtility = new TicketUtility();
    //    select * from ticket as t
//            join film as f on
//            t.filmid = f.id
//            where f.end<getdate()

    private final FilmRepository filmRepository;
    private final TicketRepository ticketRepository;

    @Override
    public TicketEntity create(TicketEntity ticket) {
        ticket.setHash(ticketUtility.createHash());
        return ticketRepository.save(ticket);
    }

    public List<TicketEntity> expiredTickets(){
        List <TicketEntity> expiredTickets = new ArrayList<>();
        expiredTickets.addAll(ticketRepository.findAllByFilmIsNotNull());
        expiredTickets.stream().filter(ticket-> ticket.getFilm().getEndTime().isBefore(LocalDateTime.now()));
        return expiredTickets;
    }

}
