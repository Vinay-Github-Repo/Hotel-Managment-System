package com.Gloitel.HospitalManagementSystem.Controller;

import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.AddPatientRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.BookAppointmentRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.ResponseDto.AddPatientResponseDto;
import com.Gloitel.HospitalManagementSystem.Model.Appointment;
import com.Gloitel.HospitalManagementSystem.Model.Patient;
import com.Gloitel.HospitalManagementSystem.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update")
    public ResponseEntity updateAddressAndPhone(@RequestParam String patientId,
                                                @RequestParam String newAddress,
                                                @RequestParam String newPhoneNo){
        try{
                  String response =  patientService.updateAddressAndPhone(patientId,newAddress,newPhoneNo);
            return new ResponseEntity(response, HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity("Patient Not Exists", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/book-appointment")
    public ResponseEntity bookAppointment(@RequestBody BookAppointmentRequestDto appointmentRequestDto){
        try{
            String response =  patientService.bookAppointment(appointmentRequestDto);
            return new ResponseEntity(response, HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity("Patient Not Exists", HttpStatus.BAD_REQUEST);
        }
    }

}
