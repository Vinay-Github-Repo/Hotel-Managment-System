package com.Gloitel.HospitalManagementSystem.Service;

import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.AddDoctorRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.ResponseDto.AddDoctorResponseDto;
import com.Gloitel.HospitalManagementSystem.Model.Appointment;
import com.Gloitel.HospitalManagementSystem.Model.Doctor;
import com.Gloitel.HospitalManagementSystem.Model.Patient;
import com.Gloitel.HospitalManagementSystem.Repository.AppointmentRepository;
import com.Gloitel.HospitalManagementSystem.Repository.DoctorRepository;
import com.Gloitel.HospitalManagementSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    public AddDoctorResponseDto addDoctor(AddDoctorRequestDto addDoctorRequestDto) {

        Doctor doctor = new Doctor();

        doctor.setDoctorId(addDoctorRequestDto.getDoctorId());
        doctor.setPassword(addDoctorRequestDto.getPassword());
        doctor.setName(addDoctorRequestDto.getName());
        doctor.setGender(addDoctorRequestDto.getGender());
        doctor.setDepartment(addDoctorRequestDto.getDepartment());

        Doctor savedDoctor = doctorRepository.save(doctor);

        AddDoctorResponseDto responseDto = new AddDoctorResponseDto();


        responseDto.setDoctorId(savedDoctor.getDoctorId());
        responseDto.setName(savedDoctor.getName());
        responseDto.setMessage("Congratulation Doctor is added");

        return responseDto;
    }

    public String removeDoctor(String doctorId) {
        String name = doctorRepository.findBydoctorId(doctorId).getName();
        doctorRepository.deleteByDoctorId(doctorId);
        return "Dr."+name+" is Removed";
    }

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }


    public List<Doctor> getAllDoctor() {
        return doctorRepository.findAll();
    }


    public Patient getPatientByUserId(String patinetId) {
        return patientRepository.findBypatientId(patinetId);
    }


    public String assignDoctorForAppointment(int appointmentId, String doctorId) {

        Appointment appointment = appointmentRepository.findById(appointmentId).get();
        appointment.setDoctor(doctorRepository.findBydoctorId(doctorId));
        appointmentRepository.save(appointment);

        Doctor doctor = doctorRepository.findBydoctorId(doctorId);
        List<Appointment> doctorAppointments= doctor.getAppointments();
        doctorAppointments.add(appointment);
        doctorRepository.save(doctor);

        Patient patient = appointment.getPatient();
        List<Appointment> patientAppointment = patient.getAppointments();
        patientAppointment.add(appointment);
        patientRepository.save(patient);

        return "Dr. "+ doctor.getName()+ " is appoint for patient "+patient.getName();


    }
}
