package com.kavya.hospitalmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestDTO {  // the purpose of creating this dto is to receive the login request in a structed way...

    private String username;
    private String password;
    
}
