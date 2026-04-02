package com.kavya.hospitalmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

import com.kavya.hospitalmanagement.entity.Patient;
import com.kavya.hospitalmanagement.service.PatientService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public")
public class PatientController {

    private final PatientService patientService;
    
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/whoami")
    public Authentication whoami(Authentication auth) {
        return auth;
    }
    
    


}
