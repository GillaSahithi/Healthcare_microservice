package com.healthcare.patient_service.controller;

import com.healthcare.patient_service.domain.Patient;
import com.healthcare.patient_service.domain.PreExistingIllness;
import com.healthcare.patient_service.dto.PatientDto;
import com.healthcare.patient_service.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto dto) {
        // Create a new patient
        Patient patient = toEntity(dto);
        // Save the patient to the database
        patient = patientService.createPatient(patient);
        dto = toDto(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    private PatientDto toDto(Patient patient) {
        return new PatientDto(patient.getPatientId(), patient.getFullName(),
                patient.getEmail(), patient.getPhone(), patient.getAddress(), patient.getDateOfBirth()4);
    }

    private Patient toEntity(PatientDto dto) {
        Patient patient = new Patient();
        patient.setFullName(dto.fullName());
        patient.setEmail(dto.email());
        patient.setPhone(dto.phone());
        patient.setAddress(dto.address());
        patient.setDateOfBirth(dto.dateOfBirth());
        return patient;
    }
}
