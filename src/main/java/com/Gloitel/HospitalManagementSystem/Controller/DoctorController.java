package com.Gloitel.HospitalManagementSystem.Controller;

import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.AddDoctorRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.ResponseDto.AddDoctorResponseDto;
import com.Gloitel.HospitalManagementSystem.Enum.AppointmentStatus;
import com.Gloitel.HospitalManagementSystem.Model.Appointment;
import com.Gloitel.HospitalManagementSystem.Model.Doctor;
import com.Gloitel.HospitalManagementSystem.Repository.AppointmentRepository;
import com.Gloitel.HospitalManagementSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PutMapping("/update-appointment-status")
    public ResponseEntity updateAppointmentStatus(@RequestParam Boolean status,
                                                  @RequestParam int appointmentId){

        try{
            String response = doctorService.updateAppointmentStatus(status,appointmentId);
            return new ResponseEntity("Appointment is Scheduled",HttpStatus.ACCEPTED);
        }catch(Exception e){
            return  new ResponseEntity("Wrong appointment is selected", HttpStatus.BAD_REQUEST);
        }
    }
}
