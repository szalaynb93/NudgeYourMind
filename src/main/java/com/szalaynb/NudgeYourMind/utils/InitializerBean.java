package com.szalaynb.NudgeYourMind.utils;

import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(ToDoNodeService toDoNodeService) {
        toDoNodeService.saveToDoNode(new ToDoNode("Run"));
        toDoNodeService.saveToDoNode(new ToDoNode("Handstand pushup"));
        toDoNodeService.saveToDoNode(new ToDoNode("Bridge from standing"));
        toDoNodeService.saveToDoNode(new ToDoNode("Eat protein"));
        toDoNodeService.saveToDoNode(new ToDoNode("Sleep"));
    }
}
