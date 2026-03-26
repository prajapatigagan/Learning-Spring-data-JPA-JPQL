package com.gagan.Hospatil_Management_System.repository;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.gagan.Hospatil_Management_System.dto.BloodGroupCountResponceEntity;
import com.gagan.Hospatil_Management_System.entity.Patient;
import com.gagan.Hospatil_Management_System.entity.type.BloodGroupType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByName(String name);
    List<Patient> findByBirthdateOrEmail(LocalDate birthdate,String email);
//    List<Patient> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
//    List<Patient> findByNameContainingOredrByIdDesc(String query);
    @Query("SELECT p FROM Patient p WHERE p.blood_group = ?1")
    List<Patient> findByBloodGroup(BloodGroupType blood_group);
    @Query("SELECT p FROM Patient p WHERE p.birthdate   >:birthdate")
    List<Patient> findByBornAfterDate(@Param ("birthdate") LocalDate birthdate);

//    @Query("SELECT p.blood_group, COUNT(p) FROM Patient p GROUP BY p.blood_group")
//    List<Object[]> countEachBloodGroupType();

    @Query("SELECT new com.gagan.Hospatil_Management_System.dto.BloodGroupCountResponceEntity(p.blood_group, COUNT(p)) " +
            "FROM Patient p GROUP BY p.blood_group")
    List<BloodGroupCountResponceEntity> countEachBloodGroupType();

//    @Query(value="select * from patient" ,nativeQuery=true)
//    List<Patient> findAllPatients();

    //paging.....
    @Query(value="select * from patient" ,nativeQuery=true)
    Page<Patient> findAllPatients(Pageable pageable);


//        @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appoinments")
    List<Patient> findAllPatientWithAppointment();
}
