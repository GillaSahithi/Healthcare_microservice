package com.healthcare.doctor_service.service;

import com.healthcare.doctor_service.domain.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    Doctor createDoctor(Doctor doctor);

    boolean checkIfDoctorExists(String doctorId);

    List<Doctor> getDoctorsByOpDays(String[] days);

    Optional<Doctor> getDoctor(String id);

    List<Doctor> getAllDoctors();
}