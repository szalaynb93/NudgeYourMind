package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.Room;
import com.szalaynb.NudgeYourMind.model.UserEntity;
import com.szalaynb.NudgeYourMind.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import java.util.List;

@RepositoryRestResource
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findById(Long id) {
        return roomRepository.findById(id).get();
    }

    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public boolean isRoomCountZero() {
        return roomRepository.count() == 0;
    }


    public List<Room> findByUsername(String name) {
        return roomRepository.findAllByUserUsername(name);
    }

    public Room findByRoomIdAndUsername(long id, UserEntity user) {
        return roomRepository.findRoomByIdAndUser(id, user);
    }
}
