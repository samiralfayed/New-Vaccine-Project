package com.vaccine.service;



import com.vaccine.model.PatientVaccine;
import com.vaccine.repository.PatientJPARepo;
import com.vaccine.repository.PatientVaccineJPARepo;
import com.vaccine.repository.VaccineJPARepo;
import com.vaccine.repository.VaccineTypeJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientVaccineServiceImpl implements PatientVaccineService {

    @Autowired
    private PatientVaccineJPARepo patientVaccineJPARepo;

    @Autowired
    private PatientJPARepo patientJPARepo;

    @Autowired
    private VaccineJPARepo vaccineJPARepo;

    @Autowired
    private VaccineTypeJPARepo vaccineTypeJPARepo;

    @Override
    public List<PatientVaccine> getAllPatientVaccines() {
        return patientVaccineJPARepo.findAll();
    }

    @Override
    public PatientVaccine savePatientVaccine(PatientVaccine patientVaccine) {
        // Save Patient if not already saved
        if (patientVaccine.getPatient() != null && patientVaccine.getPatient().getId() == null) {
            patientJPARepo.save(patientVaccine.getPatient());
        }

        // Save Vaccine if not already saved
        if (patientVaccine.getVaccine() != null && patientVaccine.getVaccine().getId() == null) {
            vaccineJPARepo.save(patientVaccine.getVaccine());
        }

        // Save VaccineType if not already saved
        if (patientVaccine.getVaccineType() != null && patientVaccine.getVaccineType().getId() == null) {
            vaccineTypeJPARepo.save(patientVaccine.getVaccineType());
        }

        return patientVaccineJPARepo.save(patientVaccine);
    }

    @Override
    public void deletePatientVaccine(Long id) {
        patientVaccineJPARepo.deleteById(id);
    }

}
