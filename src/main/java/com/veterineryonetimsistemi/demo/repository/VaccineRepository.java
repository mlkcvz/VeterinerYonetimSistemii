
package com.veterineryonetimsistemi.demo.repository;

import com.veterineryonetimsistemi.demo.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    List<Vaccine> findByAnimalId(Long animalId);
    boolean existsByAnimalIdAndNameAndCodeAndProtectionFinishDateAfter(Long animalId, String name, String code, LocalDate date);
    List<Vaccine> findByProtectionFinishDateBetween(LocalDate start, LocalDate end);
}
