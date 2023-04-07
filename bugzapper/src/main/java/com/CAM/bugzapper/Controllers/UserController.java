package com.CAM.bugzapper.Controllers;

import com.CAM.bugzapper.Models.User;
import com.CAM.bugzapper.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl service;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{userID}")
    public User getUser(@PathVariable String userID) { return this.service.getUserByID(Integer.parseInt(userID)); }

    @PostMapping("/users")
    ResponseEntity<User> addUser(@RequestBody User user) {
        Optional<User> optionalUser = service.getUserByUsername(user.getUsername());
        if(optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "User already exists!");
        } else {
            User savedUser = service.saveUser(user);

            System.out.println("added user");
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedUser.getID())
                    .toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return this.service.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable String id) {
        return this.service.deleteUser(Integer.parseInt(id));
    }
}
