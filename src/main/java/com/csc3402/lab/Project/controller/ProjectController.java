package com.csc3402.lab.Project.controller;

import com.csc3402.lab.Project.dto.UserDto;
import com.csc3402.lab.Project.model.User;
import com.csc3402.lab.Project.repository.MedicineRepository;
import com.csc3402.lab.Project.repository.PatientMedicineRepository;
import com.csc3402.lab.Project.repository.PatientRepository;
import com.csc3402.lab.Project.repository.HospitalDepartmentRepository;
import com.csc3402.lab.Project.model.Patient;
import com.csc3402.lab.Project.model.Medicine;
import com.csc3402.lab.Project.model.PatientMedicine;
import com.csc3402.lab.Project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class ProjectController {

    @Autowired
    private UserService userService;
    private PatientRepository patientRepository;
    private HospitalDepartmentRepository hospitalDepartmentRepository;

    private PatientMedicineRepository patientMedicineRepository;

    private MedicineRepository medicineRepository;

    public ProjectController(PatientRepository patientRepository, HospitalDepartmentRepository hospitalDepartmentRepository, PatientMedicineRepository patientMedicineRepository, MedicineRepository medicineRepository) {
        this.patientRepository = patientRepository;
        this.hospitalDepartmentRepository = hospitalDepartmentRepository;
        this.patientMedicineRepository = patientMedicineRepository;
        this.medicineRepository = medicineRepository;
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "list-patient";
    }

    @GetMapping("signup")
    public String showSignUpForm(Patient patient, Model model){
        model.addAttribute("hospitalDepartments", hospitalDepartmentRepository.findAll());
        return "add-patient";
    }

    // Explicitly specify GET method for fallback handler
    @GetMapping("*")
    public String fallbackHandler() {
        return "error";
    }

    @PostMapping("add")
    public String addPatient(@Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-patient";
        }

        patientRepository.save(patient);
        return "redirect:list";
    }

    @GetMapping("update")
    public String showUpdateMainForm(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "choose-patient-to-update";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Patient patient = patientRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));

        model.addAttribute("patient", patient);
        model.addAttribute("hospitalDepartments", hospitalDepartmentRepository.findAll());
        return "update-patient";
    }

    @PostMapping("update/{id}")
    public String updateStaff(@PathVariable("id") long id, @Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            patient.setPatientId((int) id);
            return "index";
        }

        model.addAttribute("patients", patientRepository.findAll());
        patientRepository.save(patient);
        return "list-patient";
    }

    @GetMapping("delete")
    public String showDeleteMainForm(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "choose-patient-to-delete";
    }

    @GetMapping("delete/{id}")
    public String deletePatient(@PathVariable("id") long id, Model model) {
        Patient patient = patientRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        patientRepository.delete(patient);
        model.addAttribute("patients", patientRepository.findAll());
        return "list-patient";
    }

    // Assign Medicine To Patient

    @GetMapping("assign")
    public String assignPatientMedicine(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "choose-medicine-to-assign";
    }

    @GetMapping("assign/{id}")
    public String showAssignMedicineForm(@PathVariable("id") long id, @Valid PatientMedicine patientMedicine, Model model) {
        Patient patient = patientRepository.findById((int) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        model.addAttribute("patient", patient);
        model.addAttribute("medicines", medicineRepository.findAll());

        return "assign-medicine";
    }

    @PostMapping("patientmedicine/{patientid}")
    public String updatePatientMedicine(@PathVariable("patientid") long id1, @Valid Medicine medi, @RequestParam String startDate,
                                        @RequestParam String endDate, @RequestParam String medPurpose, @Valid PatientMedicine patientMedicine,
                                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            patientMedicine.setId();
            return "index";
        }

        Patient patient = patientRepository.findPatientById((int) id1);
        Medicine medicine = medicineRepository.findMedicineById(medi.getMedicineId());

        PatientMedicine patientMedicine1 = new PatientMedicine(patient,medicine,startDate,endDate,medPurpose);
        patientMedicineRepository.save(patientMedicine1);

        return "index";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration (
            @Valid @ModelAttribute("user") UserDto userDto,
            BindingResult result,
            Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null)
            result.rejectValue("email", null, "User already registered !!!");

        if (result.hasErrors()) {
            model.addAttribute("user",userDto);
            return "/registration";
        }

        userService.saveUser(userDto);
        return "redirect:/registration?success";
    }
}
