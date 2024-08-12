package com.healthcare.patient_service.repository;

import com.healthcare.patient_service.domain.PreExistingIllness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreExistingIllnessRepository extends JpaRepository<PreExistingIllness,Long> {
}
