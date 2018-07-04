package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.model.enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RestResource
public interface ToDoNodeRepository extends JpaRepository<ToDoNode, Long> {

    List<ToDoNode> findAllByColor(@Param("color")Color color);
    void deleteToDoNodesByProject(Project project);

}
