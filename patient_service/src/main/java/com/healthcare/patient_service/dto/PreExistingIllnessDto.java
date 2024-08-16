package com.healthcare.patient_service.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record PreExistingIllnessDto(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        long id,

        @NotEmpty(message = "Illness is required")
        @Pattern(regexp = "^[A-Za-z\\s]+$")
        String illness
) {
}
