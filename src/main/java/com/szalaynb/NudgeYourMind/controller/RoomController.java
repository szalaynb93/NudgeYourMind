package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.model.Room;
import com.szalaynb.NudgeYourMind.model.UserEntity;
import com.szalaynb.NudgeYourMind.model.enums.Color;
import com.szalaynb.NudgeYourMind.service.RoomService;
import com.szalaynb.NudgeYourMind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class RoomController {

    private final RoomService roomService;

    private final UserService userService;

    @Autowired
    public RoomController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @PostMapping(value = "/add_room")
    public void saveRoom(@RequestParam Map<String, String> queryParameters) {
        String name = queryParameters.get("room_name");
        UserEntity user = userService.findUserByUsername(queryParameters.get("user"));
        Color color = Color.valueOf(queryParameters.get("color"));
        Room room = new Room(user, name, color);
        roomService.saveRoom(room);
        System.out.println("\n room added \n");
    }

    @PostMapping(value = "/delete_room")
    public void deleteRoom(@RequestParam Map<String, String> queryParameters) {
        Long id = Long.parseLong(queryParameters.get("roomId"));
        roomService.deleteRoom(id);
        System.out.println("\n room" + id + " deleted \n");
    }

    @GetMapping(value = "/rooms")
    public void renderRooms(Model model) {
        List<Room> rooms = roomService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAllAttributes(rooms);
    }

}
