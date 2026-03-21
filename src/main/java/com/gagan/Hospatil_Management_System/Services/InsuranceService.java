package com.gagan.Hospatil_Management_System.Services;

import com.gagan.Hospatil_Management_System.entity.Insurance;
import com.gagan.Hospatil_Management_System.entity.Patient;
import com.gagan.Hospatil_Management_System.repository.InsuranceRepository;
import com.gagan.Hospatil_Management_System.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow(()-> new EntityNotFoundException("Patient not found with id :"+patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);//bidirectional consistency maintainence

        return patient;
    }
}
