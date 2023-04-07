package com.CAM.bugzapper.Services;

import com.CAM.bugzapper.Models.Bug;

import java.util.List;
import java.util.Optional;

public interface BugService {
    List<Bug> getAllBugs();

    Bug getBugByID(int id);

    Bug saveBug(Bug bug);

    String deleteBug(int id);
}
