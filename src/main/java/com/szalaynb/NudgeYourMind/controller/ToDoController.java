package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.service.ProjectService;
import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ToDoController {

    @Autowired
    ToDoNodeService toDoNodeService;

    @Autowired
    ProjectService projectService;

    @GetMapping(value = "/all")
    public String renderEvents(Model model) {
        model.addAttribute("todolist", toDoNodeService.findAll());
        return "all";
    }


    @PostMapping(value = "/add_todo")
    public String saveToDo(@RequestParam Map<String, String> queryParameters) {
        ToDoNode toDoNode = new ToDoNode(queryParameters.get("todo_name"));
        toDoNodeService.saveToDoNode(toDoNode);
        return "redirect:/all";
    }

    @PostMapping(value = "/delete_todo")
    public @ResponseBody
    void deleteLineItem(@RequestParam Map<String, String> queryParameters) {
        Long todoId = Long.parseLong(queryParameters.get("toDoId"), 10);
        toDoNodeService.deleteToDoNode(todoId);
    }
}
