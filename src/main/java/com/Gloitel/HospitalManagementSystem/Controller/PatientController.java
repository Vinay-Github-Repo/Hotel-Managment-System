package com.Gloitel.HospitalManagementSystem.Controller;

import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.AddPatientRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.ResponseDto.AddPatientResponseDto;
import com.Gloitel.HospitalManagementSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody AddPatientRequestDto addPatientRequestDto){

        try{
            AddPatientResponseDto patientResponse = patientService.addPatient(addPatientRequestDto);
            return new ResponseEntity(patientResponse, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity("Patient already Exists", HttpStatus.BAD_REQUEST);
        }
    }
}
