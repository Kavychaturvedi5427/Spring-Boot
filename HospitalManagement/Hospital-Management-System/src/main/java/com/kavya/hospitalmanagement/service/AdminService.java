package com.kavya.hospitalmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kavya.hospitalmanagement.entity.Patient;
import com.kavya.hospitalmanagement.repository.AdminReposiroty;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminReposiroty adminRepo;

    public List<Patient> getallPatient() {
        return adminRepo.findAll();
    }
    
}
