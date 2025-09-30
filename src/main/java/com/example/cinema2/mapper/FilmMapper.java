package com.example.cinema2.mapper;

import com.example.cinema2.dto.FilmDto;
import com.example.cinema2.entity.FilmEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

        @Autowired
        private ModelMapper mapper;

        public FilmDto convertToDto(FilmEntity filmEntity) {
            return mapper.map(filmEntity, FilmDto.class);
        }

        public FilmEntity convertToEntity(FilmDto filmDto) {
            return mapper.map(filmDto, FilmEntity.class);
        }

}
