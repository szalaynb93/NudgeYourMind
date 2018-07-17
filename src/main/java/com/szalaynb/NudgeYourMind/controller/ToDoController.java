package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.model.enums.Priority;
import com.szalaynb.NudgeYourMind.model.enums.Urgency;
import com.szalaynb.NudgeYourMind.service.ProjectService;
import com.szalaynb.NudgeYourMind.service.RoomService;
import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.MalformedURLException;
import java.util.Map;

@Controller
public class ToDoController {

    private final ToDoNodeService toDoNodeService;

    private final ProjectService projectService;

    @Autowired
    public ToDoController(ToDoNodeService toDoNodeService, ProjectService projectService) {
        this.toDoNodeService = toDoNodeService;
        this.projectService = projectService;
    }

    @PostMapping(value = "/add_todo")
    public String saveToDo(@RequestParam Map<String, String> queryParameters) throws MalformedURLException {
        String name = queryParameters.get("todo_name");
        Urgency urgency = Urgency.valueOf(queryParameters.get("todo_urgency").toUpperCase());
        Priority priority = Priority.valueOf(queryParameters.get("todo_priority").toUpperCase());
        int duration = Integer.parseInt(queryParameters.get("todo_duration"));
        Project project = projectService.findById(
                Long.parseLong(queryParameters.get("todo_project"),10));
        toDoNodeService.saveToDoNode(new ToDoNode(name, urgency, duration, priority, project));
        System.out.println("\n ToDo saved \n");
        Long roomId = project.getRoom().getId();
        return "redirect:/room/"+roomId;
    }

    @PostMapping(value = "/delete_todo")
    public @ResponseBody void deleteToDo(@RequestParam Map<String, String> queryParameters) {
        Long todoId = Long.parseLong(queryParameters.get("toDoId"),10);
        toDoNodeService.deleteToDoNode(todoId);
        System.out.println("\n ToDo deleted \n");
    }

}
