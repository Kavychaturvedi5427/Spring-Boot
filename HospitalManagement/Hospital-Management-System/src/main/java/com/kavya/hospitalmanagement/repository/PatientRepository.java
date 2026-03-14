package com.kavya.hospitalmanagement.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kavya.hospitalmanagement.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // here PatientRepository is a proxy class created by spring data jpa which
    // contains all the crud operations for Patient entity
    // in service layer when we autowire this interface we can use all the methods
    // present in jpa repository...
    // at that time we don't write new PatientRepository() for creating oject
    // instead spring data jpa will create proxy class for it and craetes its object
    // and inject wherever required

    // since we're using JPA query method --> they are not available in the
    // Repository we need to provide the method signature in this interface the
    // implentation is handeled by hibernate...

    Patient findByName(String name);

    // if we want to write custom query then we have to use @Query annotation and
    // write the query in that annotation and then we can call that method in
    // service layer and it will return the result as per our query...

    // @Query("select p from Patient p where p.name = ?1") here ?1 means the first
    // parameter of the method which is name in this case...

    @Query("select p from Patient p where p.gender = :gender")
    Patient findByGender(@Param("gender")String gend);

    @Query("select p from Patient p where p.dateOfBirth > :dateOfBirth")
    List<Patient> findByBornAfter(@Param("dateOfBirth") LocalDateTime dateOfBirth);



}

// @Repository
// public interface WardRepository extends JpaRepository<Ward, Long> {
// }
