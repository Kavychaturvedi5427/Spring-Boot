package com.kavya.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kavya.hospitalmanagement.entity.Patient;
import com.kavya.hospitalmanagement.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    // if any error arises then all the changes will be rolled back to maintain the
    // data integrity and consistency in db ... but if no error arises then all the
    // changes will be commited to the db ...
    public Patient getPatientById(Long id) {
        // when this method is called for the first time it will fetch the patient from
        // the db and store it in the cache memory...
        Patient p1 = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        // when this method is called for the second time then it will first check it in
        // the cache memory (i.e persistent context) if it is present in it then simply
        // return it from their and if not then fetch from the db and store it in the
        // cache memory for next time....
        Patient p2 = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));

        // if we try to do something like this ... sout(p1 == p2) then it will return
        // true because both p1 and p2 are referring to the same object in the cache
        // memory and this is possible because of the @Transactional annotation which is
        // present in the service layer and this is one of the main advantages of using
        // @Transactional annotation in the service layer which is improving the
        // performance of our application by reducing the number of calls to the
        // database and fetching the data from the cache memory instead of fetching it
        // from the database every time...
        return p1;
    }

}
