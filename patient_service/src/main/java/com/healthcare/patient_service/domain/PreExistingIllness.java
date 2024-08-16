package com.healthcare.patient_service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PreExistingIllness {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String illnessName;

    public PreExistingIllness(String illnessName) {
        this.illnessName = illnessName;
    }
}
