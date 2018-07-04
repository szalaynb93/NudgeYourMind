package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.model.enums.Priority;
import com.szalaynb.NudgeYourMind.service.ProjectService;
import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class ToDoAndProjectController {

    private final
    ToDoNodeService toDoNodeService;

    private final
    ProjectService projectService;

    @Autowired
    public ToDoAndProjectController(ToDoNodeService toDoNodeService, ProjectService projectService) {
        this.toDoNodeService = toDoNodeService;
        this.projectService = projectService;
    }

    @GetMapping(value = "/all")
    public String renderAllToDo(Model model) {
        model.addAttribute("todolist", toDoNodeService.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "all";
    }

//    @PostMapping(value = "/add_project")
//    public String saveProject(@RequestParam Map<String, String> queryParameters) {
//        String name = queryParameters.get("project_name");
//        Project project = new Project(name);
//        projectService.saveProject(project);
//        return "redirect:/all";
//    }

    @PostMapping(value = "/add_todo")
    public String saveToDo(@RequestParam Map<String, String> queryParameters) {
        String name = queryParameters.get("todo_name");
        boolean urgency = Boolean.getBoolean(queryParameters.get("todo_urgency"));
        int duration = Integer.parseInt(queryParameters.get("todo_duration"));
        Priority priority = Priority.valueOf(queryParameters.get("todo_priority"));
        Project project = projectService.findById(Long.parseLong(queryParameters.get("todo_project")));
//todo        ToDoNode toDoNode = new ToDoNode(name, urgency, duration, priority, project);
//todo        toDoNodeService.saveToDoNode(toDoNode);
        return "redirect:/all";
    }

    @PostMapping(value = "/delete_todo")
    public @ResponseBody
    void deleteToDo(@RequestParam Map<String, String> queryParameters) {
        Long todoId = Long.parseLong(queryParameters.get("toDoId"), 10);
        toDoNodeService.deleteToDoNode(todoId);
    }

    @PostMapping(value = "/delete_project")
    @Transactional
    public @ResponseBody
    void deleteProject(@RequestParam Map<String, String> queryParameters) {
        Long projectId = Long.parseLong(queryParameters.get("projectId"), 10);
        Project project = projectService.findById(projectId);
        toDoNodeService.deleteToDoNodeByProjectId(project);
        projectService.deleteProject(projectId);
    }

}
