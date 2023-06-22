package com.csc3402.lab.Project.repository;

import com.csc3402.lab.Project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
