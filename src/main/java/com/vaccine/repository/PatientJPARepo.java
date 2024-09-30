package com.vaccine.repository;

import com.vaccine.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientJPARepo extends JpaRepository<Patient, Long> {
}
