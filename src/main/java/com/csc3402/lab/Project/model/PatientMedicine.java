package com.csc3402.lab.Project.model;

import jakarta.persistence.*;

@Entity
public class PatientMedicine {

    @EmbeddedId
    private PatientMedicineId id;

    @ManyToOne
    @MapsId("patientId")
    @JoinColumn(name = "patient_Id")
    private Patient patient;

    @ManyToOne
    @MapsId("medicineId")
    @JoinColumn(name = "medicine_Id")
    private Medicine medicine;

    @Column(name = "medicine_given_date")
    private String startDate;

    @Column(name = "next_appointment")
    private String endDate;

    @Column(name = "medicine_purpose")
    private String medPurpose;

    public PatientMedicine() {
    }

    public PatientMedicine(Patient patient,Medicine medicine, String startDate, String endDate,
                        String medPurpose) {
        this.id = new PatientMedicineId(patient.getPatientId(), medicine.getMedicineId());
        this.patient = patient;
        this.medicine = medicine;
        this.startDate = startDate;
        this.endDate = endDate;
        this.medPurpose = medPurpose;
    }

    public PatientMedicineId getId() {
        return id;
    }

    public void setId() {
        this.id = new PatientMedicineId(patient.getPatientId(),medicine.getMedicineId());
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getMedPurpose() {
        return medPurpose;
    }

    public void setMedPurpose(String medPurpose) {
        this.medPurpose = medPurpose;
    }

    @Override
    public String toString() {
        return "PatientMedicine{" +
                "id=" + id +
                ", patient=" + patient +
                ", medicine=" + medicine +
                ", Medicine Given Date='" + startDate + '\'' +
                ", Next Appointment='" + endDate + '\'' +
                ", medPurpose='" + medPurpose + '\'' +
                '}';
    }
}


