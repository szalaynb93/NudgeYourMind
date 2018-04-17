package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.enums.Priority;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.repository.ToDoNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoNodeService implements ToDoNodeServiceRequirements {

    private final ToDoNodeRepository toDoNodeRepository;

    @Autowired
    public ToDoNodeService(ToDoNodeRepository toDoNodeRepository) {
        this.toDoNodeRepository = toDoNodeRepository;
    }

    public List<ToDoNode> findAll() {
        return toDoNodeRepository.findAll();
    }

    public void saveToDoNode(ToDoNode toDoNode) {
        toDoNodeRepository.save(toDoNode);
    }

    public void deleteToDoNode(Long id) {
        toDoNodeRepository.deleteById(id);
    }

    public boolean isToDoCountZero() {
        return toDoNodeRepository.count() == 0;
    }

    @Override
    public List<ToDoNode> findByPriority(Priority priority) {
        return null;
        //TODO create repo and functionality
    }

    @Override
    public List<ToDoNode> findByProject(Project project) {
        return null;
        //TODO create repo and functionality

    }
}
