package com.example.cinema2.repo;

import com.example.cinema2.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    RoomEntity getByName(String roomName);

}
