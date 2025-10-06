package com.example.cinema2.repo;

import com.example.cinema2.entity.FilmEntity;
import com.example.cinema2.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
    FilmEntity getByName(String filmName);
}
