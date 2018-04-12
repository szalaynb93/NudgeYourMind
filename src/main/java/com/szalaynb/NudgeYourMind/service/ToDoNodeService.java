package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.repository.ToDoNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoNodeService {

    @Autowired
    ToDoNodeRepository toDoNodeRepository;

    public List<ToDoNode> findAll() {
        return toDoNodeRepository.findAll();
    }
}
