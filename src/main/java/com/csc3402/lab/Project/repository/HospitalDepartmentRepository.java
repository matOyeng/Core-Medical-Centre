package com.csc3402.lab.Project.repository;

import com.csc3402.lab.Project.model.HospitalDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HospitalDepartmentRepository extends JpaRepository<HospitalDepartment, Integer> {
}
