package com.szalaynb.NudgeYourMind.repository;

import com.szalaynb.NudgeYourMind.model.Link;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findAllByRoom(Room room);
}
