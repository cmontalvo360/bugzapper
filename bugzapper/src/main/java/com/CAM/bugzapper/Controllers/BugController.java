package com.CAM.bugzapper.Controllers;

import com.CAM.bugzapper.Models.Bug;
import com.CAM.bugzapper.Services.BugServiceImpl;
import com.CAM.bugzapper.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BugController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private BugServiceImpl bugService;

    @GetMapping("/")
    public String home() { return "<HTML><H1>My Inventory List!</H1></HTML>"; }

    @GetMapping("/admin")
    public String admin() { return "<HTML><H1>Welcome Admin!</H1></HTML>"; }

    @GetMapping("/bugs")
    public List<Bug> getBugs() { return this.bugService.getAllBugs(); }

    @GetMapping("/bugs/{bugId}")
    public Bug getBug(@PathVariable String bugId) {
        return this.bugService.getBugByID(Integer.parseInt(bugId));
    }

    @PostMapping("/bugs")
    public Bug addBug(@RequestBody Bug bug/*, @AuthenticationPrincipal UserDetails details*/) {
        //Optional<User> user = userService.findByUsernameIgnoreCase(details.getUsername());
        //bug.setLastUpdatedBy(user.get());
        return this.bugService.saveBug(bug);
    }

    @PutMapping("/bugs")
    public Bug updateBug(@RequestBody Bug bug/*, @AuthenticationPrincipal UserDetails details*/) {
        //Optional<User> user = userService.findByUsernameIgnoreCase(details.getUsername());
        //bug.setLastUpdatedBy(user.get());
        return this.bugService.saveBug(bug);
    }

    @DeleteMapping("/bugs/{bugId}")
    public String deleteBug(@PathVariable String bugId) {
        return this.bugService.deleteBug(Integer.parseInt(bugId));
    }
}