package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.enums.Priority;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.repository.ToDoNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Service;

import java.util.List;

@RepositoryRestResource
@Service
public class ToDoNodeService {

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

    public void deleteToDoNodeByProject(Project project) {
        toDoNodeRepository.deleteToDoNodesByProject(project);
    }

    public boolean isToDoCountZero() {
        return toDoNodeRepository.count() == 0;
    }

    public List<ToDoNode> findByPriority(Priority priority) {
        return null;
        //TODO create repo and functionality
    }

    public List<ToDoNode> findByProject(Project project) {
        return null;
        //TODO create repo and functionality

    }
}
