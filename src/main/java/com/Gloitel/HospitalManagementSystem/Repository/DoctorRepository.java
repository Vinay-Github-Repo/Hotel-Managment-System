package com.Gloitel.HospitalManagementSystem.Repository;

import com.Gloitel.HospitalManagementSystem.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    void deleteByDoctorId(String doctorId);

    Doctor findBydoctorId(String doctorId);
}
