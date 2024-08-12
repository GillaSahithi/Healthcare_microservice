package com.healthcare.patient_service.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record PatientDto (

        @Min(100)
        long patientId,

        @NotEmpty(message = "Name is required")
        @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name must contain only letters and spaces")
        @Length(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String fullName,

        @NotEmpty(message = "Email is required")
        @Email(message = "Email is invalid")
        String email,

        @NotEmpty(message = "Phone is required")
        @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Phone is invalid")
        String phone,

        @NotEmpty(message = "Address is required")
        @Size(min = 1, max = 250, message = "Address must be between 1 and 250 characters")
        String address,

        @Past(message = "Date of birth must be in the past")
        LocalDate dateOfBirth


) {
}
