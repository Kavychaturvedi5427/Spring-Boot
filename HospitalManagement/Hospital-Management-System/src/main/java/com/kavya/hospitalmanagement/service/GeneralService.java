package com.kavya.hospitalmanagement.service;

import com.kavya.hospitalmanagement.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kavya.hospitalmanagement.entity.Patient;

@Service
@RequiredArgsConstructor
public class GeneralService {

    private final PatientRepository repo;

    public List<Patient> getAllPatients(){
        return repo.findAll();
    }
    
}
