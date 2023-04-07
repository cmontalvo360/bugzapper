package com.CAM.bugzapper.Repositories;

import com.CAM.bugzapper.Models.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepo extends JpaRepository<Bug, Integer> {
}
