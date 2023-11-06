package com.Gloitel.HospitalManagementSystem.Service;

import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.AddPatientRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.RequestDto.BookAppointmentRequestDto;
import com.Gloitel.HospitalManagementSystem.Dto.ResponseDto.AddPatientResponseDto;
import com.Gloitel.HospitalManagementSystem.Enum.AppointmentStatus;
import com.Gloitel.HospitalManagementSystem.Model.Appointment;
import com.Gloitel.HospitalManagementSystem.Model.Patient;
import com.Gloitel.HospitalManagementSystem.Repository.DoctorRepository;
import com.Gloitel.HospitalManagementSystem.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public AddPatientResponseDto addPatient(AddPatientRequestDto addPatientRequestDto) {

        Patient patient = new Patient();

        patient.setPatientId(addPatientRequestDto.getPatientId());
        patient.setPassword(addPatientRequestDto.getPassword());
        patient.setName(addPatientRequestDto.getName());
        patient.setAge(addPatientRequestDto.getAge());
        patient.setGender(addPatientRequestDto.getGender());
        patient.setPhone_no(addPatientRequestDto.getPhone_no());
        patient.setAddress(addPatientRequestDto.getAddress());

        Patient savedPatient = patientRepository.save(patient);

        AddPatientResponseDto addPatientResponseDto = new AddPatientResponseDto();

        addPatientResponseDto.setPatientId(savedPatient.getPatientId());
        addPatientResponseDto.setName(savedPatient.getName());
        addPatientResponseDto.setMessage("Congratulation You Are Added");

        return addPatientResponseDto;

    }


    public String updateAddressAndPhone(String patientId, String newAddress, String newPhoneNo) {
        Patient patient = patientRepository.findBypatientId(patientId);
        patient.setAddress(newAddress);
        patient.setPhone_no(newPhoneNo);
        patientRepository.save(patient);
        return "Patient is updated";
    }

    public String bookAppointment(BookAppointmentRequestDto appointmentRequestDto) {

        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentRequestDto.getAppointmentDate());
        appointment.setPatientId(appointmentRequestDto.getPatientId());
        appointment.setStatus(AppointmentStatus.Request);
        appointment.setDoctorId(doctorRepository.find);

    }
}
