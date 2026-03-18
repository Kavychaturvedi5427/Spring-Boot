package com.kavya.restapi.RestApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    
    // dto feilds and entity class feilds must be the same and always use wrapper classes in dto...
    Long rollno;
    String name; 
    String aadharNumber;

}
