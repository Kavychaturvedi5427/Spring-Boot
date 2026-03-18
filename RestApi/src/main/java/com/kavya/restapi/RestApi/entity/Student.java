package com.kavya.restapi.RestApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data   // this generates the getters and setters for all the field...
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student", uniqueConstraints = {@UniqueConstraint(columnNames = { "aadhar_number" })} )   // when dealing with constraints use the naming convention of the database which is snake case... ---_----
public class Student {
    @Id
    private long rollno;
    private String name;
    // private String aadhar_Number;
    private String aadharNumber;        // java uses camel case and json follow strict naming conventions...
    
}
