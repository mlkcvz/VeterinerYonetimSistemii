
package com.veterineryonetimsistemi.demo.service.impl;

import com.veterineryonetimsistemi.demo.dto.AppointmentCreateRequest;
import com.veterineryonetimsistemi.demo.dto.AppointmentResponse;
import com.veterineryonetimsistemi.demo.entity.Animal;
import com.veterineryonetimsistemi.demo.entity.Appointment;
import com.veterineryonetimsistemi.demo.entity.Doctor;
import com.veterineryonetimsistemi.demo.exception.AlreadyExistsException;
import com.veterineryonetimsistemi.demo.exception.NotFoundException;
import com.veterineryonetimsistemi.demo.repository.AnimalRepository;
import com.veterineryonetimsistemi.demo.repository.AppointmentRepository;
import com.veterineryonetimsistemi.demo.repository.AvailableDateRepository;
import com.veterineryonetimsistemi.demo.repository.DoctorRepository;
import com.veterineryonetimsistemi.demo.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final AnimalRepository animalRepository;
    private final AvailableDateRepository availableDateRepository;
    private final ModelMapper modelMapper;

    @Override
    public AppointmentResponse createAppointment(AppointmentCreateRequest request) {
        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new NotFoundException("Doctor not found with id: " + request.getDoctorId()));
        Animal animal = animalRepository.findById(request.getAnimalId())
                .orElseThrow(() -> new NotFoundException("Animal not found with id: " + request.getAnimalId()));

        LocalDate appointmentDay = request.getAppointmentDate().toLocalDate();

        boolean available = availableDateRepository.existsByDoctorIdAndAvailableDate(doctor.getId(), appointmentDay);
        if (!available) {
            throw new AlreadyExistsException("Doktor bu tarihte çalışmamaktadır!");
        }

        boolean conflict = appointmentRepository.existsByDoctorIdAndAppointmentDate(
                request.getAppointmentDate(), doctor.getId());
        if (conflict) {
            throw new AlreadyExistsException("Girilen saatte başka bir randevu mevcuttur!");
        }

        Appointment appointment = Appointment.builder()
                .appointmentDate(request.getAppointmentDate())
                .doctor(doctor)
                .animal(animal)
                .build();

        appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentResponse.class);
    }

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Appointment not found with id: " + id));
        appointmentRepository.delete(appointment);
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByDoctorIdAndDateRange(Long doctorId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByDoctorIdAndAppointmentDateBetween(doctorId, start, end)
                .stream().map(app -> modelMapper.map(app, AppointmentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByAnimalIdAndDateRange(Long animalId, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByAnimalIdAndAppointmentDateBetween(animalId, start, end)
                .stream().map(app -> modelMapper.map(app, AppointmentResponse.class))
                .collect(Collectors.toList());
    }
}
