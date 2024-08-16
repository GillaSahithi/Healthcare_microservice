package com.healthcare.patient_service.service;

import com.healthcare.patient_service.domain.Patient;
import com.healthcare.patient_service.exceptions.DuplicatePatientException;
import com.healthcare.patient_service.exceptions.PatientNotFoundException;
import com.healthcare.patient_service.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientService {

   @Autowired
    private  PatientRepository patientRepository;

//    public PatientService(PatientRepository patientRepository) {
//        this.patientRepository = patientRepository;
//    }

    public Patient createPatient(Patient patient) {
        log.debug("Creating patient: {}", patient);
        patientRepository
                .findByEmailOrPhone(patient.getEmail(), patient.getPhone())
                .ifPresent(existingPatient -> {
                    log.error("Patient already exists with email: {} or phone: {}",
                            existingPatient.getEmail(), existingPatient.getPhone());
                    throw new DuplicatePatientException("Patient already exists with email: " +
                            existingPatient.getEmail() + " or phone: " + existingPatient.getPhone());
                });
        log.debug("Patient does not exist with email: {} or phone: {}", patient.getEmail(), patient.getPhone());
        return patientRepository.save(patient);
    }

    public Patient getPatient(long id) {
        log.debug("Getting patient, id: {}", id);
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found, id: " + id));
    }

    public Patient updatePatient(Patient patient) {
        log.debug("Updating patient: {}", patient);
        return patientRepository.save(patient);
    }

    public void deletePatient(long id) {
        log.debug("Deleting patient, id: {}", id);
        var patient = patientRepository
                .findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found, cannot delete, id: " + id));
        patientRepository.delete(patient);
    }

    public Patient searchByEmail(String email) {
        log.debug("Searching patient by email: {}", email);
        return patientRepository.findByEmail(email)
                .orElseThrow(() ->
                        new PatientNotFoundException("Patient not found, email: " + email));
    }

    public Patient searchByPhone(String phone) {
        log.debug("Searching patient by phone: {}", phone);
        return patientRepository.findByPhone(phone)
                .orElseThrow(() ->
                        new PatientNotFoundException("Patient not found, phone: " + phone));
    }

    public List<Patient> getAllPatients() {
        log.debug("Getting all patients");
        return List.copyOf(patientRepository.findAll());
    }

}
