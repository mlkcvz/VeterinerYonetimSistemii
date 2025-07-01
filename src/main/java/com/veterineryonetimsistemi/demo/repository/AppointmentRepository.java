
package com.veterineryonetimsistemi.demo.repository;

import com.veterineryonetimsistemi.demo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    boolean existsByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);
    List<Appointment> findByDoctorIdAndAppointmentDateBetween(Long doctorId, LocalDateTime start, LocalDateTime end);
    List<Appointment> findByAnimalIdAndAppointmentDateBetween(Long animalId, LocalDateTime start, LocalDateTime end);
}
