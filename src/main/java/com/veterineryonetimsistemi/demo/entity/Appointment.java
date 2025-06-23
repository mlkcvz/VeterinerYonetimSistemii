
package com.veterineryonetimsistemi.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    //Bir hayvan ile veteriner hekim arasındaki randevuyu temsil eder.
    // Tarih, saat ve ilgili taraflar bilgilerini içerir.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
