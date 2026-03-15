package com.gagan.Hospatil_Management_System;

import com.gagan.Hospatil_Management_System.Services.PatientServices;
import com.gagan.Hospatil_Management_System.entity.Patient;
import com.gagan.Hospatil_Management_System.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientServices patientServices;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList=patientRepository.findAll();
        System.out.println(patientList);

        Patient p1=new Patient();
        p1.setName("Ravi");
        p1.setEmail("ravi@gmail.com");
        p1.setGender("Male");

        patientRepository.save(p1);
    }
    @Test
    public void testTransactionMethods(){
//        Patient patient=patientServices.getPatientById(1L);
//        Patient patient=patientRepository.findByName("Anita");
        List<Patient> patientList= (List<Patient>) patientRepository.findByBirthDateOrEmail(LocalDate.of(1998,8,21),"anita@gmail.com");
        for(Patient patient:patientList) {
            System.out.println(patientList);
        }
    }
}
