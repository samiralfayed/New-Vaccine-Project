package com.vaccine.controller;

import com.vaccine.model.PatientVaccine;
import com.vaccine.service.PatientVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient-vaccine")
public class PatientVaccineController {

    @Autowired
    private PatientVaccineService patientVaccineService;

    @GetMapping
    public List<PatientVaccine> getAllPatientVaccines() {
        return patientVaccineService.getAllPatientVaccines();
    }

    @PostMapping 
    @ResponseBody
    public PatientVaccine addPatientVaccine(@RequestBody PatientVaccine patientVaccine) {
        return patientVaccineService.savePatientVaccine(patientVaccine);
    }



    @PutMapping("/{id}")
    public PatientVaccine updatePatientVaccine(@PathVariable Long id, @RequestBody PatientVaccine updatedPatientVaccine) {
        // Set the ID of the updated PatientVaccine to ensure we're updating the correct record
        updatedPatientVaccine.setId(id);
        return patientVaccineService.savePatientVaccine(updatedPatientVaccine);
    }




    @DeleteMapping("/{id}")
    public void deletePatientVaccine(@PathVariable Long id) {
        patientVaccineService.deletePatientVaccine(id);
    }
}
