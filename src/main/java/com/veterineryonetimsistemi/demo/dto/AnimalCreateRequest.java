
package com.veterineryonetimsistemi.demo.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalCreateRequest {
    //Yeni bir hayvan oluşturmak için kullanılan API veri transfer nesnesidir (DTO).
    private String name;
    private String species;
    private String breed;
    private String gender;
    private String colour;
    private LocalDate dateOfBirth;
    private Long customerId;
}
