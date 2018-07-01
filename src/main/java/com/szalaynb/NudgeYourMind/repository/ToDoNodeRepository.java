package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

public interface ToDoNodeRepository extends JpaRepository<ToDoNode, Long> {
    void deleteToDoNodesByProject(Project project);
}
