
package com.veterineryonetimsistemi.demo.repository;

import com.veterineryonetimsistemi.demo.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByAnimalId(Long animalId);
    boolean existsByAnimalIdAndNameAndCodeAndProtectionFinishDateAfter(Long animalId, String name, String code, LocalDate date);
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate start, LocalDate end);
}
