package com.healthcare.patient_service.converter;

import com.healthcare.patient_service.domain.Patient;
import com.healthcare.patient_service.dto.PatientDto;
import org.springframework.stereotype.Component;

@Component
public class PatientDtoConverter {
    public PatientDto toDto(Patient patient) {
        return new PatientDto(patient.getPatientId(), patient.getFullName(),
                patient.getEmail(), patient.getPhone(), patient.getAddress(), patient.getDateOfBirth(), patient.getPreExistingIllness());
    }

    public Patient toEntity(PatientDto dto) {
        Patient patient = new Patient();
        patient.setFullName(dto.fullName());
        patient.setEmail(dto.email());
        patient.setPhone(dto.phone());
        patient.setAddress(dto.address());
        patient.setDateOfBirth(dto.dateOfBirth());
        patient.setPreExistingIllness(dto.preExistingIllness());
        return patient;
    }
}
