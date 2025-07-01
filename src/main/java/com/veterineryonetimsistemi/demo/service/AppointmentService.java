
package com.veterineryonetimsistemi.demo.service;

import com.veterineryonetimsistemi.demo.dto.AppointmentCreateRequest;
import com.veterineryonetimsistemi.demo.dto.AppointmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;



public interface AppointmentService {
    AppointmentResponse createAppointment(AppointmentCreateRequest request);
    void deleteAppointment(Long id);
    List<AppointmentResponse> getAppointmentsByDoctorIdAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end);
    List<AppointmentResponse> getAppointmentsByAnimalIdAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end);
}
