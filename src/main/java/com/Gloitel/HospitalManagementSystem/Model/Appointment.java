package com.Gloitel.HospitalManagementSystem.Model;

import com.Gloitel.HospitalManagementSystem.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreationTimestamp
    Date appointmentDate;

    @ManyToOne
    @JoinColumn
    String patientId;

    @ManyToOne
    @JoinColumn
    String doctorId;

    @Enumerated(EnumType.STRING)
    AppointmentStatus status;

}