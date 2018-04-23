package com.szalaynb.NudgeYourMind.utils;

import com.szalaynb.NudgeYourMind.model.enums.Color;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.model.enums.Priority;
import com.szalaynb.NudgeYourMind.service.ProjectService;
import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializerBean {

    @Autowired
    private ToDoNodeService toDoNodeService;

    @Autowired
    private ProjectService projectService;

    @PostConstruct
    public void init() {

        if (projectService.isProjectCountZero()) {
            projectService.saveProject(new Project("Sport"));
        }

        Project sport = projectService.findById(1L);

        if (toDoNodeService.isToDoCountZero()) {
            toDoNodeService.saveToDoNode(new ToDoNode(
                    "Bridge",false,30, Priority.P2, sport));
            toDoNodeService.saveToDoNode(new ToDoNode(
                    "One handed push up",false,30, Priority.P2, sport));
            toDoNodeService.saveToDoNode(new ToDoNode(
                    "Handstand pushup",false,30, Priority.P2, sport));
            toDoNodeService.saveToDoNode(new ToDoNode(
                    "Squats",false,30, Priority.P2, sport));
            toDoNodeService.saveToDoNode(new ToDoNode(
                    "Deadlift",false,30, Priority.P2, sport));
            toDoNodeService.saveToDoNode(new ToDoNode(
                    "Pull up",false,30, Priority.P2, sport));

        }
    }
}
