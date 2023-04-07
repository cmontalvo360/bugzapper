package com.CAM.bugzapper.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectID;
    private String name;
    private String description;
    private String starDate;
    private String endDate;
    @OneToMany
    private List<Bug> bugs;
}
