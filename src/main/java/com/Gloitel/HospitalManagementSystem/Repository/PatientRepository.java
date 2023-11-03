package com.Gloitel.HospitalManagementSystem.Repository;

import com.Gloitel.HospitalManagementSystem.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
