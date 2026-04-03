package com.kavya.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDTO { // the purpose of creating this dto is to send the response of the login request in a structured way..
    
    private String jwt;
    private Long userId;
    
}
