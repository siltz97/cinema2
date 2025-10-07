package com.example.cinema2.repo;

import com.example.cinema2.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<SeatEntity, Long> {
    List<SeatEntity> findAllByOccupiedFalseAndRoom_Name(String roomName);
}
