package com.healthcare.patient_service.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record PreExistingIllnessDto(
        long id,

        @NotEmpty(message = "Illness is required")
        @Pattern(regexp = "^[A-Za-z\\s]+$")
                                    String illness
) {
}
