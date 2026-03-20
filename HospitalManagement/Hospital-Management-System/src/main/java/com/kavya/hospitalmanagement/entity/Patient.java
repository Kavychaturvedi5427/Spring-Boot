package com.kavya.hospitalmanagement.entity;

import java.time.LocalDateTime;

import org.hibernate.OrderingMode;

import com.kavya.hospitalmanagement.type.BloodGroupType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
// import lombok.ToString;

@Entity
@Getter
@Setter
// @ToString the use of this annotation is to generate the toString method for
// the class and it will return the string representation of the object when we
// call the toString method on that object...
public class Patient {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private LocalDateTime dateOfBirth;
    private String gender;
    @Enumerated(EnumType.STRING)        // by defualt it will use string...
    private BloodGroupType bloodgroup;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                '}';
    }
}
