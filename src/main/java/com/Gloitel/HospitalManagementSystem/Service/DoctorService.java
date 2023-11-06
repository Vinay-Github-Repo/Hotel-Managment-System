package com.Gloitel.HospitalManagementSystem.Service;


import com.Gloitel.HospitalManagementSystem.Enum.AppointmentStatus;
import com.Gloitel.HospitalManagementSystem.Model.Appointment;
import com.Gloitel.HospitalManagementSystem.Model.Doctor;
import com.Gloitel.HospitalManagementSystem.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    AppointmentRepository appointmentRepository;


    public String updateAppointmentStatus(Boolean status, int appointmentId){

            Appointment appointment = appointmentRepository.findById(appointmentId).get();
            if(status){
                appointment.setStatus(AppointmentStatus.Scheduled);
                appointmentRepository.save(appointment);
                return "Appointment is Scheduled";
            }else {
                appointment.setStatus(AppointmentStatus.Canceled);
                appointmentRepository.save(appointment);
                return "Appointment is Rejected";
            }
    }
}

