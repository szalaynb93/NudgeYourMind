package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.model.Link;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.Room;
import com.szalaynb.NudgeYourMind.model.UserEntity;
import com.szalaynb.NudgeYourMind.model.enums.Color;
import com.szalaynb.NudgeYourMind.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RoomController {

    private final RoomService roomService;
    private final UserService userService;
    private final LinkService linkService;
    private final ToDoNodeService toDoNodeService;
    private final ProjectService projectService;

    @Autowired
    public RoomController(RoomService roomService, UserService userService, LinkService linkService, ToDoNodeService toDoNodeService, ProjectService projectService) {
        this.roomService = roomService;
        this.userService = userService;
        this.linkService = linkService;
        this.toDoNodeService = toDoNodeService;
        this.projectService = projectService;
    }

    @PostMapping(value = "/add_room")
    public void saveRoom(@RequestParam Map<String, String> queryParameters) {
        String name = queryParameters.get("room_name");
        UserEntity user = userService.findUserByUsername(queryParameters.get("user"));
        Color color = Color.valueOf(queryParameters.get("color").toUpperCase());
        Room room = new Room(user, name, color);
        roomService.saveRoom(room);
        System.out.println("\n room added \n");
    }


    @PostMapping(value = "/delete_room")
    @Transactional
    public void deleteRoom(@RequestParam Map<String, String> queryParameters) {
        Long id = Long.parseLong(queryParameters.get("roomId"), 10);
        Room room = roomService.findById(id);
        List<Project> projects = room.getRoomsProjectList();
        for (Project project : projects) {
            toDoNodeService.deleteToDoNodeByProject(project);
            projectService.deleteProject(project.getId());
        }
        List<Link> links = room.getLinkList();
        for (Link link : links) {
            linkService.deletelink(link.getId());
        }
        roomService.deleteRoom(id);
        System.out.println("\n room" + id + " and its content is deleted \n");
    }

    @GetMapping(value = "/rooms")
    public String renderRooms(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Room> rooms = roomService.findByUsername(username);
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @RequestMapping(value = "/room/{roomId}", method = RequestMethod.GET)
    public String renderRoom(@PathVariable("roomId") String roomId, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("\n" + username);
        UserEntity user = userService.findUserByUsername(username);
        Room room = roomService.findByRoomIdAndUsername(Long.parseLong(roomId, 10), user);
        System.out.println("\n" + room.getName());
        model.addAttribute("projects", projectService.findAllByRoom(room));
        return "room";
    }

//    @GetMapping(value = "/room")
//    public String renderRoom(Model model) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        List<Room> rooms = roomService.findByUsername(username);
//        List<Project> projects = projectService.findAllByRoom(rooms.get(0));
//        model.addAttribute("projects", projects);
//        return "room";
//    }


}
