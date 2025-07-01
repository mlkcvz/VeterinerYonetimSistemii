
package com.veterineryonetimsistemi.demo.service;

import com.veterineryonetimsistemi.demo.dto.CustomerCreateRequest;
import com.veterineryonetimsistemi.demo.dto.CustomerResponse;
import com.veterineryonetimsistemi.demo.dto.CustomerUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CustomerService {
    CustomerResponse createCustomer(CustomerCreateRequest request);
    CustomerResponse updateCustomer(Long id, CustomerUpdateRequest request);
    void deleteCustomer(Long id);
    List<CustomerResponse> getAllCustomers();
    List<CustomerResponse> searchByName(String name);
    CustomerResponse getCustomerById(Long id);
}
