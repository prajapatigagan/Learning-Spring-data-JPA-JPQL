package com.gagan.Hospatil_Management_System.Services;

import com.gagan.Hospatil_Management_System.entity.Appoinment;
import com.gagan.Hospatil_Management_System.entity.Doctor;
import com.gagan.Hospatil_Management_System.entity.Patient;
import com.gagan.Hospatil_Management_System.repository.AppoinmentRepository;
import com.gagan.Hospatil_Management_System.repository.DoctorRepository;
import com.gagan.Hospatil_Management_System.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppoinmentService {
    private final AppoinmentRepository appoinmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appoinment createNewAppoinment(Appoinment appoinment,Long doctorId,Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorId));
        Patient patient=patientRepository.findById(patientId).orElseThrow();

        if (appoinment.getId()!=null)throw new IllegalArgumentException("Appointment should not have id");
        appoinment.setPatient(patient);
        appoinment.setDoctor(doctor);

        patient.getAppoinments().add(appoinment);// to maintain consistency

        return appoinmentRepository.save(appoinment);
    }

    @Transactional
    public Appoinment reAssignAppoinmentTOAnotherDoctor(Long appoinmentId,Long doctorId){
        Appoinment appoinment=appoinmentRepository.findById(appoinmentId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appoinment.setDoctor(doctor);//this will automatically call the update,because it is dirty

        doctor.getAppoinments().add(appoinment);//just for bidirectional consistency

        return appoinment;
    }
}
