
package com.veterineryonetimsistemi.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vaccine {
    //Bir hayvana uygulanmış aşı bilgisini içerir. Başlangıç ve bitiş tarihleri ile birlikte tutulur.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private LocalDate protectionStartDate;
    private LocalDate protectionFinishDate;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;
}
