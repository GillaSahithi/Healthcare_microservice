package com.healthcare.patient_service.service;

import com.healthcare.patient_service.domain.Patient;
import com.healthcare.patient_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatient(long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found, id: " + id));
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> getAllPatients() {
        return List.copyOf(patientRepository.findAll());
    }

}
