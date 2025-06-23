
package com.veterineryonetimsistemi.demo.controller;

import com.veterineryonetimsistemi.demo.dto.VaccineCreateRequest;
import com.veterineryonetimsistemi.demo.dto.VaccineResponse;
import com.veterineryonetimsistemi.demo.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vaccines")
@RequiredArgsConstructor
public class VaccineController {

    private final VaccineService vaccineService;

    @PostMapping
    public ResponseEntity<VaccineResponse> createVaccine(@RequestBody VaccineCreateRequest request) {
        return ResponseEntity.ok(vaccineService.createVaccine(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccine(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/animal/{animalId}")
    public ResponseEntity<List<VaccineResponse>> getVaccinesByAnimalId(@PathVariable Long animalId) {
        return ResponseEntity.ok(vaccineService.getVaccinesByAnimalId(animalId));
    }

    @GetMapping("/between")
    public ResponseEntity<List<VaccineResponse>> getVaccinesByProtectionDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(vaccineService.getVaccinesByProtectionDateBetween(start, end));
    }
}
