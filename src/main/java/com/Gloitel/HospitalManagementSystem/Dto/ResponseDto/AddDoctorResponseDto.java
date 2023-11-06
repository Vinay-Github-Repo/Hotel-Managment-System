package com.Gloitel.HospitalManagementSystem.Dto.ResponseDto;


import com.Gloitel.HospitalManagementSystem.Enum.Department;
import com.Gloitel.HospitalManagementSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddDoctorResponseDto {

    String doctorId;
    String name;
    String message;
}
