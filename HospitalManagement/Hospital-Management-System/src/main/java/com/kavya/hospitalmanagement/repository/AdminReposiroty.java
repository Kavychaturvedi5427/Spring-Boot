package com.kavya.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kavya.hospitalmanagement.entity.Patient;

@Repository
public interface AdminReposiroty extends JpaRepository<Patient, Long> {

}
