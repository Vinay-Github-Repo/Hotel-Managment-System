package com.Gloitel.HospitalManagementSystem.Dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPatientResponseDto {

    String patientId;
    String name;
    String message;
}
