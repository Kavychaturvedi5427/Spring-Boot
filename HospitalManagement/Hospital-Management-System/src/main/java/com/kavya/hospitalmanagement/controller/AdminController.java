package com.kavya.hospitalmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kavya.hospitalmanagement.entity.Patient;
import com.kavya.hospitalmanagement.service.AdminService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    
    private final AdminService adminService;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatient() {
        return ResponseEntity.ok(adminService.getallPatient());
    }
    
    
}
