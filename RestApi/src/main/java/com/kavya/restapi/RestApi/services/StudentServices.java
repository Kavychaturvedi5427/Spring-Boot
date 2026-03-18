package com.kavya.restapi.RestApi.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.kavya.restapi.RestApi.dto.StudentDTO;
import com.kavya.restapi.RestApi.entity.Student;
import com.kavya.restapi.RestApi.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServices {

    private final StudentRepository repository;
    private final ModelMapper mapper;

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public StudentDTO addStudent(StudentDTO stuDto) {
        Student newStudent = mapper.map(stuDto, Student.class);
        return mapper.map(repository.save(newStudent), StudentDTO.class);
    }
}
