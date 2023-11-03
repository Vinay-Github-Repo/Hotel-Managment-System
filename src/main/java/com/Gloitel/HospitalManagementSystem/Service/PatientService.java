package com.Gloitel.HospitalManagementSystem.Service;

import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.AddPatientRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.ResponseDto.AddPatientResponseDto;
import com.Gloitel.HospitalManagementSystem.Enum.Gender;
import com.Gloitel.HospitalManagementSystem.Model.Patient;
import com.Gloitel.HospitalManagementSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public AddPatientResponseDto addPatient(AddPatientRequestDto addPatientRequestDto) {

        Patient patient = new Patient();
        patient.setPatientId(addPatientRequestDto.getPatientId());
        patient.setPassword(addPatientRequestDto.getPassword());
        patient.setName(addPatientRequestDto.getName());
        patient.setAge(addPatientRequestDto.getAge());
        patient.setGender(addPatientRequestDto.getGender());
        patient.setPhone_no(addPatientRequestDto.getPhone_no());

        Patient savedPatient = patientRepository.save(patient);

        AddPatientResponseDto addPatientResponseDto = new AddPatientResponseDto();
        addPatientResponseDto.setPatientId(savedPatient.getPatientId());
        addPatientResponseDto.setName(savedPatient.getName());
        addPatientResponseDto.setMessage("Congratulation You Are Added");

        return addPatientResponseDto;

    }
}
