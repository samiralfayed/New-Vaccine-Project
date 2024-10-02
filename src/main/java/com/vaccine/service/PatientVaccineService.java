package com.vaccine.service;

import com.vaccine.model.PatientVaccine;

import java.util.List;

public interface PatientVaccineService {

    List<PatientVaccine> getAllPatientVaccines();
    PatientVaccine savePatientVaccine(PatientVaccine patientVaccine);
    void deletePatientVaccine(Long id);

}
