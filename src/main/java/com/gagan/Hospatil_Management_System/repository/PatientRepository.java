package com.gagan.Hospatil_Management_System.repository;

import com.gagan.Hospatil_Management_System.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
    Patient findByBirthDateOrEmail(LocalDate birthdate, String email);
}
