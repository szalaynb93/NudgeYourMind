package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements ProjectServiceRequirements {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    public boolean isProjectCountZero() {
        return projectRepository.count() == 0;
    }
}
