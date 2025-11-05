package com.example.cinema2.repo;

import com.example.cinema2.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    List<TicketEntity> findAllByFilmIsNotNull();
}
