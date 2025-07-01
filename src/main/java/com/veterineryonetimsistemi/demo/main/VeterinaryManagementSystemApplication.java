
package com.veterineryonetimsistemi.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.veterineryonetimsistemi.demo")
@EnableJpaRepositories(basePackages = "com.veterineryonetimsistemi.demo.repository")
@EntityScan(basePackages = "com.veterineryonetimsistemi.demo.entity")
public class VeterinaryManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeterinaryManagementSystemApplication.class, args);
    }
}
