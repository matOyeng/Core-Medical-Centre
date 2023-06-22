package com.csc3402.lab.Project.controller;

import com.csc3402.lab.Project.model.Patient;
import com.csc3402.lab.Project.model.PatientMedicine;
import com.csc3402.lab.Project.repository.HospitalDepartmentRepository;
import com.csc3402.lab.Project.repository.MedicineRepository;
import com.csc3402.lab.Project.repository.PatientMedicineRepository;
import com.csc3402.lab.Project.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class UserController {
    private PatientRepository patientRepository;
    private PatientMedicineRepository patientMedicineRepository;

    public UserController(PatientRepository patientRepository,PatientMedicineRepository patientMedicineRepository) {
        this.patientRepository = patientRepository;
        this.patientMedicineRepository = patientMedicineRepository;
    }
    @GetMapping("display")
    public String displayPatientMedicine(Model model) {
        model.addAttribute("patients", patientRepository.findAll());

        return "choose-medicine-to-display";
    }

    @GetMapping("display/{patientid}")
    public String showDisplayMedicineForm(@PathVariable("patientid") long id, Model model) {
        List<PatientMedicine> patientMedicine = (List<PatientMedicine>) patientMedicineRepository.findPatientMedicineByPatientId((int) id);
        model.addAttribute("patient", patientRepository.findPatientById((int)id));
        model.addAttribute("patientMedicines", patientMedicine);

        return "display-medicine";
    }

}