package com.CAM.bugzapper.Services;

import com.CAM.bugzapper.Models.Bug;
import com.CAM.bugzapper.Models.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProjects();

    Project getProjectByID(int id);

    Project saveProject(Project project);

    String deleteProject(int id);
}
