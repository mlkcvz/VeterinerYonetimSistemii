
package com.veterineryonetimsistemi.demo.service;

import com.veterineryonetimsistemi.demo.dto.VaccineCreateRequest;
import com.veterineryonetimsistemi.demo.dto.VaccineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



public interface VaccineService {
    VaccineResponse createVaccine(VaccineCreateRequest request);
    void deleteVaccine(Long id);
    List<VaccineResponse> getVaccinesByAnimalId(Long animalId);
    List<VaccineResponse> getVaccinesByProtectionDateBetween(LocalDate start, LocalDate end);
}
