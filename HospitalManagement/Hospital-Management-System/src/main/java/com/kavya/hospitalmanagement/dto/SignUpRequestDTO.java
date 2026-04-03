package com.kavya.hospitalmanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignUpRequestDTO {

    private String username;
    private String password;

}
