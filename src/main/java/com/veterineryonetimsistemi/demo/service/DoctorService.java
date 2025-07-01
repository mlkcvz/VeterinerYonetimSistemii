
package com.veterineryonetimsistemi.demo.service;

import com.veterineryonetimsistemi.demo.dto.DoctorCreateRequest;
import com.veterineryonetimsistemi.demo.dto.DoctorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



public interface DoctorService {
    DoctorResponse createDoctor(DoctorCreateRequest request);
    void deleteDoctor(Long id);
    DoctorResponse getDoctorById(Long id);
    List<DoctorResponse> getAllDoctors();
}
