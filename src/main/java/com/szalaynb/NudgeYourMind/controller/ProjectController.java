package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.Room;
import com.szalaynb.NudgeYourMind.service.ProjectService;
import com.szalaynb.NudgeYourMind.service.RoomService;
import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    private final ToDoNodeService toDoNodeService;

    private final RoomService roomService;

    @Autowired
    public ProjectController(ProjectService projectService, ToDoNodeService toDoNodeService, RoomService roomService) {
        this.projectService = projectService;
        this.toDoNodeService = toDoNodeService;
        this.roomService = roomService;
    }


    @PostMapping(value = "/add_project")
    public String saveProject(@RequestParam Map<String, String> queryParameters, HttpSession session) {
        String name = queryParameters.get("project_name");
        Long roomId = Long.parseLong(session.getAttribute("room_id").toString(), 10);
        Room room = roomService.findById(roomId);
        projectService.saveProject(new Project(name, room));
        System.out.println("\n project added \n");
        return "redirect:/room/1";
    }


    @PostMapping(value = "/delete_project")
    @Transactional
    public @ResponseBody void deleteProject(@RequestParam Map<String, String> queryParameters) {
        Long projectId = Long.parseLong(queryParameters.get("projectId"), 10);
        Project project = projectService.findById(projectId);
        toDoNodeService.deleteToDoNodeByProject(project);
        projectService.deleteProject(projectId);
        System.out.println("\n project and related todos are deleted \n");
    }

}
