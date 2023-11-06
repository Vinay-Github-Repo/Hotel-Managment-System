package com.Gloitel.HospitalManagementSystem.Dto.RequestDto;


import com.Gloitel.HospitalManagementSystem.Enum.Department;
import com.Gloitel.HospitalManagementSystem.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddDoctorRequestDto {


    String doctorId;
    String password;
    String name;
    Gender gender;
    Department department;
}
