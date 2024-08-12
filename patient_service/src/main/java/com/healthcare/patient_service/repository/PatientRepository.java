package com.healthcare.patient_service.repository;

import com.healthcare.patient_service.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
