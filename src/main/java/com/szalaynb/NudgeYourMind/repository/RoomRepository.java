package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByUserUsername(String username);
}
