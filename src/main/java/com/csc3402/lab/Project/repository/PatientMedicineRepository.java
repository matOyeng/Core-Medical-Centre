package com.csc3402.lab.Project.repository;

import com.csc3402.lab.Project.model.PatientMedicine;
import com.csc3402.lab.Project.model.PatientMedicineId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientMedicineRepository extends JpaRepository<PatientMedicine, PatientMedicineId> {

    @Query(value = "SELECT * FROM patient_medicine where PATIENT_ID = :id" , nativeQuery = true)
    List<PatientMedicine> findPatientMedicineByPatientId(@Param("id") int id);
}
