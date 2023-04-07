package com.CAM.bugzapper.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bugID;
    private String status;
    private String priority;
    private String description;
    private String resolution;
    @ManyToOne
    private Project project;
    private LocalDate createDate;
    @OneToOne
    private User createdBy;
    @OneToOne
    private User developer;
    private LocalDate lastUpdate;
    @OneToOne
    private User lastUpdatedBy;

    public Bug() { }

    public Bug(String status, String priority, String description, String resolution, Project project, LocalDate createDate, User createdBy, User developer, LocalDate lastUpdate, User lastUpdatedBy) {
        this.status = status;
        this.priority = priority;
        this.description = description;
        this.resolution = resolution;
        this.project = project;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.developer = developer;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getBugID() {
        return bugID;
    }

    public void setBugID(int bugID) { this.bugID = bugID; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    public User getDeveloper() {
        return developer;
    }

    public void setDeveloper(User developer) {
        this.developer = developer;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public User getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(User lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
}