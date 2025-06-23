
package com.veterineryonetimsistemi.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentCreateRequest {
    private Long doctorId;
    private Long animalId;
    private LocalDateTime appointmentDate;
}
