package com.CAM.bugzapper.Repositories;

import com.CAM.bugzapper.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameIgnoreCase(String username);
}
