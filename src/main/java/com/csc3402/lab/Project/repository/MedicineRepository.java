package com.csc3402.lab.Project.repository;

import com.csc3402.lab.Project.model.PatientMedicine;
import com.csc3402.lab.Project.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

    @Query(value = "SELECT * FROM medicine where medicine_id = :id" , nativeQuery = true)
    Medicine findMedicineById(@Param("id") int id);
}
