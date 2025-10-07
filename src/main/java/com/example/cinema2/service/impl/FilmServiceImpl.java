package com.example.cinema2.service.impl;

import com.example.cinema2.entity.FilmEntity;
import com.example.cinema2.repo.FilmRepository;
import com.example.cinema2.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;
    public void save(FilmEntity filmEntity) {
        filmRepository.save(filmEntity);
    }
}
