package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.ToDoNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoNodeRepository extends JpaRepository<ToDoNode, Long> {
}
