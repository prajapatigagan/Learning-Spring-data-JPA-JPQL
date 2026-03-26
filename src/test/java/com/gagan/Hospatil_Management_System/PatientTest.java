package com.gagan.Hospatil_Management_System;

import com.gagan.Hospatil_Management_System.Services.PatientServices;
import com.gagan.Hospatil_Management_System.dto.BloodGroupCountResponceEntity;
import com.gagan.Hospatil_Management_System.entity.Patient;
import com.gagan.Hospatil_Management_System.entity.type.BloodGroupType;
import com.gagan.Hospatil_Management_System.repository.PatientRepository;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
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
//        List<Patient> patientList=patientRepository.findAll();
        List<Patient> patientList=patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
//
//        Patient p1=new Patient();
//        p1.setName("Ravi");
//        p1.setEmail("ravi@gmail.com");
//        p1.setGender("Male");

//        patientRepository.save(p1);
    }
    @Test
    public void testTransactionMethods(){
//        Patient patient=patientServices.getPatientById(1L);
//        Patient patient=patientRepository.findByName("Anita");
//        List<Patient> patientList = patientRepository
//                .findByBirthdateOrEmail(LocalDate.of(1998,8,21),"anita@gmail.com");

//        List<Patient> patientList=patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);

//        List<Patient> patientList=patientRepository.findByBornAfterDate(LocalDate.of(1985,8,28));
//        System.out.println(patientList.size());

//        List<Patient> patientList=patientRepository.findAllPatients();
//        for(Patient patient : patientList){
//            System.out.println(patient);
//        }
//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] object : bloodGroupList){
//            System.out.println(object[0] + " " + object[1]);
//        }

//        List<BloodGroupCountResponceEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponceEntity BloodGroupCountResponce: bloodGroupList){
//            System.out.println(BloodGroupCountResponce);
//        }
//        List<BloodGroupCountResponceEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//
//        for (BloodGroupCountResponceEntity bloodGroupResponse : bloodGroupList) {
//            System.out.println(bloodGroupResponse);
//        }

        //paging.....
        Page<Patient> patientPage = patientRepository.findAllPatients(PageRequest.of(4,6));
        List<Patient> patientList = patientPage.getContent();
        for (Patient patient : patientList) {
            System.out.println(patient);
        }

    }
}
