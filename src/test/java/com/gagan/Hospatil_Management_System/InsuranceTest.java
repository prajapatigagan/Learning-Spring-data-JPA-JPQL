package com.gagan.Hospatil_Management_System;


import com.gagan.Hospatil_Management_System.Services.AppoinmentService;
import com.gagan.Hospatil_Management_System.Services.InsuranceService;
import com.gagan.Hospatil_Management_System.entity.Appoinment;
import com.gagan.Hospatil_Management_System.entity.Doctor;
import com.gagan.Hospatil_Management_System.entity.Insurance;
import com.gagan.Hospatil_Management_System.entity.Patient;
import com.gagan.Hospatil_Management_System.repository.DoctorRepository;
import com.gagan.Hospatil_Management_System.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;


@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppoinmentService appoinmentService;

    @Test
    public void testInsurance(){
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC_12345")
                .provider("HDFC")
                .velidUntil(LocalDate.of(2025,11,12))
                .build();

        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1l);
        System.out.println(patient);
    }

    @Test
    public void testCreateAppoinment(){
        Appoinment appoinment=Appoinment.builder()
                .appointmentTime(LocalDateTime.of(2024,12,23,12,45,05))
                .reason("cancer")
                .build();
        var newAppoinment=appoinmentService.createNewAppoinment(appoinment,1L,2L);
        System.out.println(newAppoinment);
    }

}
