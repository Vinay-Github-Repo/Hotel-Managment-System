package com.Gloitel.HospitalManagementSystem.Controller;

import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.AddDoctorRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.ResponseDto.AddDoctorResponseDto;
import com.Gloitel.HospitalManagementSystem.Model.Doctor;
import com.Gloitel.HospitalManagementSystem.Model.Patient;
import com.Gloitel.HospitalManagementSystem.Repository.DoctorRepository;
import com.Gloitel.HospitalManagementSystem.Service.AdminService;
import com.Gloitel.HospitalManagementSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    DoctorService doctorService;


    @PostMapping("/DoctorAdd")
    public ResponseEntity addDoctor(@RequestBody AddDoctorRequestDto addDoctorRequestDto){

        try {
            AddDoctorResponseDto doctorResponseDto = adminService.addDoctor(addDoctorRequestDto);
            return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity("Doctor Already Exist", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/removeDoctor{doctorId}")
    public ResponseEntity removeDoctor(@RequestParam("doctorId") String doctorId){
        try{
            String message = adminService.removeDoctor(doctorId);
            return new ResponseEntity(message, HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity("Doctor is Not Present",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-patient")
    public List<Patient> getAllPatient(){

        return adminService.getAllPatient();
    }

    @GetMapping("/get-all-doctor")
    public List<Doctor> getAllDoctor(){
        return  adminService.getAllDoctor();
    }

    @GetMapping("/get-patient-by-userId")
    public ResponseEntity getPatientByUserId(String patinetId){
        try{
            Patient patient = adminService.getPatientByUserId(patinetId);
            return new ResponseEntity(patient,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity("Patient Is Not Present", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/assign-doctor-for-appointment")
    public ResponseEntity assignDoctorForAppointment(@RequestParam int appointmentId,
                                                     @RequestParam String doctorId){
        String response = adminService.assignDoctorForAppointment(appointmentId,doctorId);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
