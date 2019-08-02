package com.kapped.msspbrewary.services;

import com.kapped.msspbrewary.web.model.CustomerDTO;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomreById(UUID customerId);

    CustomerDTO saveNewCustomerDTO(CustomerDTO customerDTO);

    void updateCustomerDTO(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomerDTOById(UUID customerId);
}
