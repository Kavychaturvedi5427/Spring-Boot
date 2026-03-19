package com.kavya.restapi.RestApi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kavya.restapi.RestApi.dto.StudentDTO;
import com.kavya.restapi.RestApi.entity.Student;
import com.kavya.restapi.RestApi.services.StudentServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentServices services;

    @GetMapping("/students")
    @ResponseBody
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(services.getAllStudents());
    }

    // @PostMapping("/students/add")    here we're using post mapping which means we're already adding a new student so using add in the url is not a good practice..
    @PostMapping("/students")
    public ResponseEntity<StudentDTO> addNewStudents(@RequestBody StudentDTO stuDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(services.addStudent(stuDto));
    }

}
