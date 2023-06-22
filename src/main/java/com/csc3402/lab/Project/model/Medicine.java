package com.csc3402.lab.Project.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_Id")
    private Integer medicineId;

    @Column(name = "medicine_name")
    private String medName;

    @OneToMany(mappedBy = "medicine")
    private Set<PatientMedicine> patientMedicines = new HashSet<>();

    public Medicine() {
    }

    public Medicine(String medName) {
        this.medName = medName;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public Set<PatientMedicine> getPatientMedicines() {
        return patientMedicines;
    }

    public void setPatientMedicines(Set<PatientMedicine> patientMedicines) {
        this.patientMedicines = patientMedicines;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", medName='" + medName + '\'' +
                ", patientMedicines=" + patientMedicines +
                '}';
    }
}
