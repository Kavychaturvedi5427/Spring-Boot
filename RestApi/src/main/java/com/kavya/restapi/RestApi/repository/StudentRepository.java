package com.kavya.restapi.RestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kavya.restapi.RestApi.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    
}
