
package com.veterineryonetimsistemi.demo.service.impl;

import com.veterineryonetimsistemi.demo.dto.DoctorCreateRequest;
import com.veterineryonetimsistemi.demo.dto.DoctorResponse;
import com.veterineryonetimsistemi.demo.entity.Doctor;
import com.veterineryonetimsistemi.demo.exception.AlreadyExistsException;
import com.veterineryonetimsistemi.demo.exception.NotFoundException;
import com.veterineryonetimsistemi.demo.repository.DoctorRepository;
import com.veterineryonetimsistemi.demo.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    @Override
    public DoctorResponse createDoctor(DoctorCreateRequest request) {
        if (doctorRepository.findByMail(request.getMail()).isPresent()) {
            throw new AlreadyExistsException("Bu mail adresiyle kayıtlı doktor zaten var.");
        }
        Doctor doctor = modelMapper.map(request, Doctor.class);
        doctorRepository.save(doctor);
        return modelMapper.map(doctor, DoctorResponse.class);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + id));
        doctorRepository.delete(doctor);
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + id));
        return modelMapper.map(doctor, DoctorResponse.class);
    }

    @Override
    public List<DoctorResponse> getAllDoctors() {
        return doctorRepository.findAll()
                .stream().map(doc -> modelMapper.map(doc, DoctorResponse.class))
                .collect(Collectors.toList());
    }
}
