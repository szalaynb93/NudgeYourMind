package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {

    @Autowired
    ToDoNodeService toDoNodeService;

    @GetMapping(value = "/all")
    public String renderEvents(Model model) {
        model.addAttribute("todolist", toDoNodeService.findAll());
        return "todolist";
    }
}
