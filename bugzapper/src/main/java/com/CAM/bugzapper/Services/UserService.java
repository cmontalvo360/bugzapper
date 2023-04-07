package com.CAM.bugzapper.Services;

import com.CAM.bugzapper.Models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    User getUserByID(int id);

    Optional<User> getUserByUsername(String username);

    User saveUser(User user);

    String deleteUser(int id);
}
