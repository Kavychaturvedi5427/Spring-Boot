package com.kavya.hospitalmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kavya.hospitalmanagement.dto.LoginRequestDTO;
import com.kavya.hospitalmanagement.dto.LoginResponseDTO;
import com.kavya.hospitalmanagement.dto.SignUpRequestDTO;
import com.kavya.hospitalmanagement.dto.SignUpResponseDTO;
import com.kavya.hospitalmanagement.security.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> Login(@RequestBody LoginRequestDTO loginRequest) {
        return ResponseEntity.ok(authService.Login(loginRequest));
    }   

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDTO> signup(@RequestBody SignUpRequestDTO signUpRequest) {
        return ResponseEntity.ok(authService.signup(signUpRequest));
    }
    
    
    
}