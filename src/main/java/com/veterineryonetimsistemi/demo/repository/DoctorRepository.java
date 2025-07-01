
package com.veterineryonetimsistemi.demo.repository;

import com.veterineryonetimsistemi.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByMail(String mail);
}
