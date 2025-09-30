package com.example.cinema2.mapper;

import com.example.cinema2.dto.TicketDto;
import com.example.cinema2.entity.TicketEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    @Autowired
    private ModelMapper mapper;

    public TicketDto convertToDto(TicketEntity ticketEntity) {
        return mapper.map(ticketEntity, TicketDto.class);
    }

    public TicketEntity convertToEntity(TicketDto ticketDto) {
        return mapper.map(ticketDto, TicketEntity.class);
    }
}
