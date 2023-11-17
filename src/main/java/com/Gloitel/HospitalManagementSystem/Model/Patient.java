package com.Gloitel.HospitalManagementSystem.Model;

import com.Gloitel.HospitalManagementSystem.Enum.BloodGroup;
import com.Gloitel.HospitalManagementSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    String patientId;

    String password;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    BloodGroup blood_group;

    Boolean blood_sign;//(+,-)

    String phone_no;

    String address;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    List<Appointment> appointments=new ArrayList<>();

    String prescription;

    
}
