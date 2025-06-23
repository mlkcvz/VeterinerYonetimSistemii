
package com.veterineryonetimsistemi.demo.service.impl;

import com.veterineryonetimsistemi.demo.dto.VaccineCreateRequest;
import com.veterineryonetimsistemi.demo.dto.VaccineResponse;
import com.veterineryonetimsistemi.demo.entity.Animal;
import com.veterineryonetimsistemi.demo.entity.Vaccine;
import com.veterineryonetimsistemi.demo.exception.AlreadyExistsException;
import com.veterineryonetimsistemi.demo.exception.NotFoundException;
import com.veterineryonetimsistemi.demo.repository.AnimalRepository;
import com.veterineryonetimsistemi.demo.repository.VaccineRepository;
import com.veterineryonetimsistemi.demo.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;
    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;

    @Override
    public VaccineResponse createVaccine(VaccineCreateRequest request) {
        if (vaccineRepository.existsByAnimalIdAndNameAndCodeAndProtectionFinishDateAfter(
                request.getAnimalId(), request.getName(), request.getCode(), LocalDate.now())) {
            throw new AlreadyExistsException("Bu hayvan için bu aşı hala geçerli, tekrar girilemez.");
        }

        Animal animal = animalRepository.findById(request.getAnimalId())
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + request.getAnimalId()));

        Vaccine vaccine = modelMapper.map(request, Vaccine.class);
        vaccine.setAnimal(animal);
        vaccineRepository.save(vaccine);

        return modelMapper.map(vaccine, VaccineResponse.class);
    }

    @Override
    public void deleteVaccine(Long id) {
        Vaccine vaccine = vaccineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vaccine not found with id: " + id));
        vaccineRepository.delete(vaccine);
    }

    @Override
    public List<VaccineResponse> getVaccinesByAnimalId(Long animalId) {
        return vaccineRepository.findByAnimalId(animalId)
                .stream().map(vac -> modelMapper.map(vac, VaccineResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VaccineResponse> getVaccinesByProtectionDateBetween(LocalDate start, LocalDate end) {
        return vaccineRepository.findByProtectionFinishDateBetween(start, end)
                .stream().map(vac -> modelMapper.map(vac, VaccineResponse.class))
                .collect(Collectors.toList());
    }
}
