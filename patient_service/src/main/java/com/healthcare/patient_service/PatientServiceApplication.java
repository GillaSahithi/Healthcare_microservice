package com.healthcare.patient_service;

import com.healthcare.patient_service.domain.Patient;
import com.healthcare.patient_service.domain.PreExistingIllness;
import com.healthcare.patient_service.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PatientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
//        return args -> {
//            Patient patient = new Patient();
//            PreExistingIllness p = new PreExistingIllness("fever");
//            PreExistingIllness q = new PreExistingIllness("cold");
//            List<PreExistingIllness> l = new ArrayList<>();
//            l.add(p);
//            l.add(q);
//            patient.setFullName("John Doe");patient.setFullName("John Doe");
////            patient.setEmail("john.doe");
//            patient.setEmail("john.doe");
//            patient.setPhone("9876543210");
//            patient.setAddress("xyz");
//            patient.setDateOfBirth(LocalDate.of(2024, 8, 10));
//            patient.setPreExistingIllness(l);
//            patientRepository.save(patient);
//            System.out.println("Employee saved: " + patient);
//
//
//            patientRepository.findAll().forEach(System.out::println);
//
//        };
//    }
}