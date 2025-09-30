package com.example.cinema2.mapper;

import com.example.cinema2.dto.RoomDto;
import com.example.cinema2.entity.RoomEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    @Autowired
    private ModelMapper mapper;

    public RoomDto convertToDto(RoomEntity roomEntity) {
        return mapper.map(roomEntity, RoomDto.class);
    }

    public RoomEntity convertToEntity(RoomDto roomDto) {
        return mapper.map(roomDto, RoomEntity.class);
    }
}
