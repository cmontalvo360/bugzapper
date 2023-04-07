package com.CAM.bugzapper.Services;

import com.CAM.bugzapper.Models.User;
import com.CAM.bugzapper.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUsers() { return this.userRepo.findAll(); }

    @Override
    public User getUserByID(int userID) {
        Optional<User> user = this.userRepo.findById(userID);
        if(user.isEmpty()) {
            throw new RuntimeException("User not found for id: " + userID);
        }

        return user.get();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> user = this.userRepo.findByUsernameIgnoreCase(username);
        if(user.isEmpty()) {
            throw new RuntimeException("User not found for username: " + username);
        }
        return user;
    }

    @Override
    public User saveUser(User user) {
        //user.setUsername(user.getUsername().toLowerCase());
        //user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }

    @Override
    public String deleteUser(int userId) {
        this.userRepo.deleteById(userId);
        return "User deleted";
    }
}
