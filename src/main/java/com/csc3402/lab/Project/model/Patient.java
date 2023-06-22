package com.csc3402.lab.Project.model;
import jakarta.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientId;

    @Column(name = "first_name")
    private String fname;

    @Column(name = "last_name")
    private String lname;

    @Column(name = "sickness")
    private String sickness;

    @ManyToOne
    @JoinColumn(name = "hosp_dept_id")
    public HospitalDepartment hospitalDepartment;

    // constructor
    public Patient() {
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public HospitalDepartment getHospitalDepartment() {
        return hospitalDepartment;
    }

    public void setHospitalDepartment(HospitalDepartment hospitalDepartment) {
        this.hospitalDepartment = hospitalDepartment;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", firstName='" + fname + '\'' +
                ", lastName='" + lname + '\'' +
                ", sickness=" + sickness +
                '}';
    }
}
