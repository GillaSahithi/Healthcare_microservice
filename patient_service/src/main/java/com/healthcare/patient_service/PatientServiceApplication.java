package com.healthcare.patient_service;

import com.healthcare.patient_service.domain.Patient;
import com.healthcare.patient_service.domain.PreExistingIllness;
import com.healthcare.patient_service.repository.PatientRepository;
import com.healthcare.patient_service.repository.PreExistingIllnessRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PatientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PatientRepository patientRepository, PreExistingIllnessRepository pr) {
        return args -> {
            Patient patient = new Patient();
            patient.setFullName("John Doe");
            patient.setEmail("john.doe");
            patient.setPhone("9876543210");
            patient.setAddress("xyz");
            patient.setDateOfBirth(LocalDate.of(2024, 8, 10));
            patientRepository.save(patient);
            System.out.println("Employee saved: " + patient);

            Patient x = new Patient();
            x.setFullName("abc");
            x.setEmail("abc.doe");
            x.setPhone("9876543218");
            x.setAddress("guyz");
            x.setDateOfBirth(LocalDate.of(2024, 9, 10));
            patientRepository.save(x);
            System.out.println("Employee saved: " + patient);

            PreExistingIllness p = new PreExistingIllness();
            p.setIllness("jaundice");
            pr.save(p);

            patientRepository.findAll().forEach(System.out::println);
            pr.findAll().forEach(System.out::println);
        };
    }
}