package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.Priority;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;

import java.util.List;

public interface ToDoNodeServiceRequirements {

    List<ToDoNode> findAll();
    void saveToDoNode(ToDoNode toDoNode);
    void deleteToDoNode(Long id);

    List<ToDoNode> findByPriority(Priority priority);
    List<ToDoNode> findByProject(Project project);

}
