package com.kavya.hospitalmanagement;

import java.security.PKCS12Attribute;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kavya.hospitalmanagement.entity.Patient;
import com.kavya.hospitalmanagement.repository.PatientRepository;
import com.kavya.hospitalmanagement.service.PatientService;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test // this class helps in running all the code(repository level) related to paitent
          // without running the entire application and creating api's for it ....
    public void testPatient() {
        List<Patient> patientList = patientRepository.findAll();
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }

    @Test
    public void testTransactionalMethod() {
        // when we're running this method this is calling the getPatientById method in
        // service layer and in that method we're calling the findById method of patient
        // repository twice and both the calls are fetching the same patient from
        // database and storing it in cache memory and when we call the findById method
        // second time it will fetch the patient from cache memory instead of fetching
        // it from database which is improving the performance of our application and
        // this is possible because of @Transactional annotation which is present in
        // service layer...

        // Patient patient = patientService.getPatientById(1L);
        // System.out.println(patient);

        // patient = patientRepository.findByName("Naman");
        // System.out.println(patient);

        Patient p1 = patientRepository.findByGender("female");
        System.out.println(p1);

        List<Patient> p2 = patientRepository.findByBornAfter(LocalDateTime.of(1995, 1, 1, 0, 0));
        System.out.println(p2);


    }

}
