package com.szalaynb.NudgeYourMind.utils;

import com.szalaynb.NudgeYourMind.model.enums.Color;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
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
            projectService.saveProject(new Project("Incoming", Color.WHITE));
        }

        if (toDoNodeService.isToDoCountZero()) {
            toDoNodeService.saveToDoNode(new ToDoNode("Run"));
            toDoNodeService.saveToDoNode(new ToDoNode("Handstand pushup"));
            toDoNodeService.saveToDoNode(new ToDoNode("Bridge from standing"));
            toDoNodeService.saveToDoNode(new ToDoNode("Eat protein"));
            toDoNodeService.saveToDoNode(new ToDoNode("Sleep"));
        }
    }
}
