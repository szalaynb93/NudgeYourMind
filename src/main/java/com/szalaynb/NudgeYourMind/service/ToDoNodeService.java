package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.repository.ToDoNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
