package com.healthcare.patient_service.repository;

import com.healthcare.patient_service.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Optional<Patient> findByEmail(String email);

    Optional<Patient> findByPhone(String phone);

    Optional<Patient> findByEmailOrPhone(String email, String phone);

//    List<Patient> findByDobBetween(LocalDate startDate, LocalDate endDate);
//
//    Optional<List<Patient>> findIllnessesOfPatient(@Param("patientId") long pid);
}
