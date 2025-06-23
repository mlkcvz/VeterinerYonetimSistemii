
package com.veterineryonetimsistemi.demo.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalResponse {
    //API üzerinden geri döndürülen hayvan verilerini taşıyan veri transfer nesnesidir.
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate dateOfBirth;
    private CustomerResponse customer;
}
