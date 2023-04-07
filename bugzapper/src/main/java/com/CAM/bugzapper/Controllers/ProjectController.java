package com.CAM.bugzapper.Controllers;

import com.CAM.bugzapper.Models.Project;
import com.CAM.bugzapper.Services.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectServiceImpl projectService;
    @GetMapping("/projects")
    public List<Project> getProjects() {
        return this.projectService.getAllProjects();
    }

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable String id) {
        return this.projectService.getProjectByID(Integer.parseInt(id));
    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project/*, @AuthenticationPrincipal UserDetails details*/) {
        //Optional<User> user = userService.findByUsernameIgnoreCase(details.getUsername());
        //bug.setLastUpdatedBy(user.get());
        return this.projectService.saveProject(project);
    }
    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project/*, @AuthenticationPrincipal UserDetails details*/) {
        //Optional<User> user = userService.findByUsernameIgnoreCase(details.getUsername());
        //bug.setLastUpdatedBy(user.get());
        return this.projectService.saveProject(project);
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProject(@PathVariable String id) {
        return this.projectService.deleteProject(Integer.parseInt(id));
    }
}
