package com.kavya.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data       // generates all boilerplate code like getter/setters hashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomDto {
    private String name;
    private String address;
}
