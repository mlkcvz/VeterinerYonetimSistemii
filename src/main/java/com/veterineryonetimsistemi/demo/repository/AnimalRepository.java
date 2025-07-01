
package com.veterineryonetimsistemi.demo.repository;

import com.veterineryonetimsistemi.demo.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByCustomerId(Long customerId);
    List<Animal> findByNameContainingIgnoreCase(String name);
}
