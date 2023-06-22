package com.csc3402.lab.Project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PatientMedicineId implements Serializable {

    @Column(name = "patient_Id")
    private Integer patientId;

    @Column(name = "project_Id")
    private Integer medicineId;

    public PatientMedicineId() {
    }

    public PatientMedicineId(Integer patientId, Integer medicineId) {
        this.patientId = patientId;
        this.medicineId = medicineId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientMedicineId that = (PatientMedicineId) o;
        return Objects.equals(patientId, that.patientId) && Objects.equals(medicineId,
                that.medicineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, medicineId);
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    @Override
    public String toString() {
        return "PatientMedicineId{" +
                "patientId=" + patientId +
                ", medicineId=" + medicineId +
                '}';
    }
}
