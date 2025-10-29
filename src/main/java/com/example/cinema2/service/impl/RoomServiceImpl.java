package com.example.cinema2.service.impl;

import com.example.cinema2.entity.RoomEntity;
import com.example.cinema2.repo.RoomRepository;
import com.example.cinema2.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public void save(RoomEntity roomEntity) {
        roomRepository.save(roomEntity);
    }
}
