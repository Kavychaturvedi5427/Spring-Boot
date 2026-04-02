package com.kavya.hospitalmanagement.controller;

import com.kavya.hospitalmanagement.service.GeneralService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

import com.kavya.hospitalmanagement.entity.Patient;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/general")
@RequiredArgsConstructor
public class GeneralController {
    
    private final GeneralService generalService;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatientsEntity() {
        return ResponseEntity.ok(generalService.getAllPatients());
    }
    


}
