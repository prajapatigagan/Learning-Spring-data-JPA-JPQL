package com.gagan.Hospatil_Management_System;

import com.gagan.Hospatil_Management_System.Services.InsuranceService;
import com.gagan.Hospatil_Management_System.entity.Insurance;
import com.gagan.Hospatil_Management_System.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest

public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .velidUntil(LocalDate.of(2025,11,12))
                .build();

        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1l);
        System.out.println(patient);
    }
}
