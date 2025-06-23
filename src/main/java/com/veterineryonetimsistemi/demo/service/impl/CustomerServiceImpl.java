
package com.veterineryonetimsistemi.demo.service.impl;

import com.veterineryonetimsistemi.demo.dto.CustomerCreateRequest;
import com.veterineryonetimsistemi.demo.dto.CustomerResponse;
import com.veterineryonetimsistemi.demo.dto.CustomerUpdateRequest;
import com.veterineryonetimsistemi.demo.entity.Customer;
import com.veterineryonetimsistemi.demo.exception.NotFoundException;
import com.veterineryonetimsistemi.demo.repository.CustomerRepository;
import com.veterineryonetimsistemi.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public CustomerResponse createCustomer(CustomerCreateRequest request) {
        if (customerRepository.findByMail(request.getMail()).isPresent()) {
            throw new RuntimeException("Kayıt sistemde mevcut.");
        }

        Customer customer = modelMapper.map(request, Customer.class);
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerResponse.class);
    }

    @Override
    public CustomerResponse updateCustomer(Long id, CustomerUpdateRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " id'li müşteri bulunamadı."));
        modelMapper.map(request, customer);
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerResponse.class);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " id'li müşteri bulunamadı."));
        customerRepository.delete(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream().map(c -> modelMapper.map(c, CustomerResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<CustomerResponse> searchByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name)
                .stream().map(c -> modelMapper.map(c, CustomerResponse.class)).collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id + " id'li müşteri bulunamadı."));
        return modelMapper.map(customer, CustomerResponse.class);
    }
}
