
package com.veterineryonetimsistemi.demo.service.impl;

import com.veterineryonetimsistemi.demo.dto.AnimalCreateRequest;
import com.veterineryonetimsistemi.demo.dto.AnimalResponse;
import com.veterineryonetimsistemi.demo.entity.Animal;
import com.veterineryonetimsistemi.demo.entity.Customer;
import com.veterineryonetimsistemi.demo.exception.NotFoundException;
import com.veterineryonetimsistemi.demo.repository.AnimalRepository;
import com.veterineryonetimsistemi.demo.repository.CustomerRepository;
import com.veterineryonetimsistemi.demo.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public AnimalResponse createAnimal(AnimalCreateRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found with id: " + request.getCustomerId()));
        Animal animal = modelMapper.map(request, Animal.class);
        animal.setCustomer(customer);
        animalRepository.save(animal);
        return modelMapper.map(animal, AnimalResponse.class);
    }

    @Override
    public void deleteAnimal(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + id));
        animalRepository.delete(animal);
    }

    @Override
    public AnimalResponse getAnimalById(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + id));
        return modelMapper.map(animal, AnimalResponse.class);
    }

    @Override
    public List<AnimalResponse> getAllAnimals() {
        return animalRepository.findAll()
                .stream().map(animal -> modelMapper.map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AnimalResponse> getAnimalsByCustomerId(Long customerId) {
        return animalRepository.findByCustomerId(customerId)
                .stream().map(animal -> modelMapper.map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AnimalResponse> searchByName(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name)
                .stream().map(animal -> modelMapper.map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
    }
}
