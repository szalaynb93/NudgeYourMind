package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.Room;
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

    public void saveroom(Room room) {
        roomRepository.save(room);
    }

    public void deleteroom(Long id) {
        roomRepository.deleteById(id);
    }


}
