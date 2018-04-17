package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectServiceRequirements {

    List<Project> findAll();
    Optional<Project> findById(Long id);
    void saveProject(Project project);
}
