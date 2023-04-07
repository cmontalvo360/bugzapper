package com.CAM.bugzapper.Services;

import com.CAM.bugzapper.Models.Project;
import com.CAM.bugzapper.Repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepo projectRepo;

    @Override
    public List<Project> getAllProjects() {
        return this.projectRepo.findAll();
    }

    @Override
    public Project getProjectByID(int id) {
        Optional<Project> project = this.projectRepo.findById(id);
        if(project.isEmpty()) {
            throw new RuntimeException("User not found for id: " + id);
        }

        return project.get();
    }

    @Override
    public Project saveProject(Project project) {
        return this.projectRepo.save(project);
    }

    @Override
    public String deleteProject(int id) {
        this.projectRepo.deleteById(id);
        return "Project deleted";
    }
}
