package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long id) {
        return projectRepository.findById(id).get();
    }

    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public boolean isProjectCountZero() {
        return projectRepository.count() == 0;
    }
}
