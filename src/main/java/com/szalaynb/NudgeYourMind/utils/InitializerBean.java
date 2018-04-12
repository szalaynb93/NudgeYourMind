package com.szalaynb.NudgeYourMind.utils;

import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {

    public InitializerBean(ToDoNodeService toDoNodeService) {
        toDoNodeService.saveToDoNode(new ToDoNode("Run", 4));
        toDoNodeService.saveToDoNode(new ToDoNode("Handstand pushup", 2));
        toDoNodeService.saveToDoNode(new ToDoNode("Bridge from standing", 5));
        toDoNodeService.saveToDoNode(new ToDoNode("Eat protein", 1));
        toDoNodeService.saveToDoNode(new ToDoNode("Sleep", 2));
    }
}
