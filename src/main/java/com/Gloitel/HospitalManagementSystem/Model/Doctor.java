package com.Gloitel.HospitalManagementSystem.Model;

import com.Gloitel.HospitalManagementSystem.Enum.Department;
import com.Gloitel.HospitalManagementSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String doctorId;

    String password;

    String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    Department department;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Appointment> appointments= new ArrayList<>();
}
