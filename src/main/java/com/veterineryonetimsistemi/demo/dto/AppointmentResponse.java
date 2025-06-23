
package com.veterineryonetimsistemi.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentResponse {
    private Long id;
    private LocalDateTime appointmentDate;
    private AnimalResponse animal;
    private DoctorResponse doctor;
}
