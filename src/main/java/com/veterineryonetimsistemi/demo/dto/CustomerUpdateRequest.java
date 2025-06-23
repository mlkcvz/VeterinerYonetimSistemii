
package com.veterineryonetimsistemi.demo.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerUpdateRequest {
    private String name;
    private String phone;
    private String mail;
    private String address;
    private String city;
}
