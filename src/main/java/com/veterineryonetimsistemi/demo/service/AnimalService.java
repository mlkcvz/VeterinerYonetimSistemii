
package com.veterineryonetimsistemi.demo.service;

import com.veterineryonetimsistemi.demo.dto.AnimalCreateRequest;
import com.veterineryonetimsistemi.demo.dto.AnimalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



public interface AnimalService {
    AnimalResponse createAnimal(AnimalCreateRequest request);
    void deleteAnimal(Long id);
    AnimalResponse getAnimalById(Long id);
    List<AnimalResponse> getAllAnimals();
    List<AnimalResponse> getAnimalsByCustomerId(Long customerId);
    List<AnimalResponse> searchByName(String name);
}
