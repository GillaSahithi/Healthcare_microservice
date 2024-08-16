package com.healthcare.doctor_service.service;

import com.healthcare.doctor_service.domain.Doctor;
import com.healthcare.doctor_service.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepo;

    public DoctorServiceImpl(DoctorRepository doctorRepo){
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public boolean checkIfDoctorExists(String doctorId) {
        return doctorRepo.existsById(doctorId);
    }

    @Override
    public List<Doctor> getDoctorsByOpDays(String[] days) {
        return List.copyOf(doctorRepo.findAllByOpDaysContains(days));
    }

    @Override
    public Optional<Doctor> getDoctor(String id) {
        return doctorRepo.findById(id);
    }

    @Override
    public List<Doctor> getAllDoctors(){
        return List.copyOf(doctorRepo.findAll());
    }
}