
package com.veterineryonetimsistemi.demo.controller;

import com.veterineryonetimsistemi.demo.dto.AnimalCreateRequest;
import com.veterineryonetimsistemi.demo.dto.AnimalResponse;
import com.veterineryonetimsistemi.demo.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;



    @PostMapping
    public ResponseEntity<AnimalResponse> createAnimal(@RequestBody AnimalCreateRequest request) {
        return ResponseEntity.ok(animalService.createAnimal(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponse> getAnimalById(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.getAnimalById(id));
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponse>> getAllAnimals() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AnimalResponse>> getAnimalsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(animalService.getAnimalsByCustomerId(customerId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnimalResponse>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(animalService.searchByName(name));
    }
}
