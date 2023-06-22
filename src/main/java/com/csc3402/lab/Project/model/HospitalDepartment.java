package com.csc3402.lab.Project.model;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class HospitalDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hosp_dept_id")
    private Integer hospDeptId;

    @Column(name = "hosp_dept_name")
    private String hospDeptName;

    @OneToMany(mappedBy = "hospitalDepartment", cascade = CascadeType.ALL)
    private Set<Patient> patients;


    // constructors
    public HospitalDepartment() {
        super();
    }

    public HospitalDepartment(Integer hospDeptId, String hospDeptName) {
        this.hospDeptId = hospDeptId;
        this.hospDeptName = hospDeptName;
    }

    public Integer getHospDeptId() {
        return hospDeptId;
    }

    public void setHospDeptId(Integer hospDeptId) {
        this.hospDeptId = hospDeptId;
    }

    public String getHospDeptName() {
        return hospDeptName;
    }

    public void setHospDeptName(String hospDeptName) {
        this.hospDeptName = hospDeptName;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
    @Override
    public String toString() {
        return "HospitalDepartment{" +
                "hospDeptId=" + hospDeptId +
                ", hospDeptName='" + hospDeptName + '\'' +
          '}';
}
}
