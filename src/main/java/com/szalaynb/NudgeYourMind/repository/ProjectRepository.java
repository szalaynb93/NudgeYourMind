package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.Room;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByRoom(Room room);
}
