
package com.veterineryonetimsistemi.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailableDate {
    //Bir veteriner hekimin çalışabileceği belirli bir tarihi temsil eder.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate availableDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
