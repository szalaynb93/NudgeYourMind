package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.Room;
import com.szalaynb.NudgeYourMind.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByUserUsername(String username);

    Room findRoomByIdAndUser(Long id, UserEntity user);
}
