package com.Gloitel.HospitalManagementSystem.Dto.RequestDto;

import com.Gloitel.HospitalManagementSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPatientRequestDto {

    String patientId;
    String password;
    String name;
    int age;
    Gender gender;
    String phone_no;

}
