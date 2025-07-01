
package com.veterineryonetimsistemi.demo.repository;

import com.veterineryonetimsistemi.demo.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    boolean existsByDoctorIdAndAvailableDate(Long doctorId, LocalDate date);
}
