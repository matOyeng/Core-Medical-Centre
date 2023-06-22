package com.csc3402.lab.Project.repository;

import com.csc3402.lab.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
