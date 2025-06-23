
package com.veterineryonetimsistemi.demo.repository;

import com.veterineryonetimsistemi.demo.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    boolean existsByDoctorIdAndAvailableDate(Long doctorId, LocalDate date);
}
