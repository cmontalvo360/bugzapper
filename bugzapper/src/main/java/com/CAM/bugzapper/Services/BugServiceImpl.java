package com.CAM.bugzapper.Services;

import com.CAM.bugzapper.Models.Bug;
import com.CAM.bugzapper.Repositories.BugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugServiceImpl implements BugService{
    @Autowired
    private BugRepo bugRepo;
    @Override
    public List<Bug> getAllBugs() {
        return this.bugRepo.findAll();
    }
    @Override
    public Bug getBugByID(int bugId) {
        Optional<Bug> optionalBug = this.bugRepo.findById(bugId);
        Bug bug = null;
        if(optionalBug.isPresent()) {
            bug = optionalBug.get();
        } else {
            throw new RuntimeException("Bug not found for id: " + bugId);
        }
        return bug;
    }
    @Override
    public Bug saveBug(Bug bug) {
        return this.bugRepo.save(bug);
    }
    @Override
    public String deleteBug(int bugId) {
        this.bugRepo.deleteById(bugId);
        return "Bug deleted!";
    }
}
