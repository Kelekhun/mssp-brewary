package com.kapped.msspbrewary.services;

import com.kapped.msspbrewary.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

    @Override
    public CustomerDTO getCustomreById(UUID customerId) {
        return CustomerDTO
                .builder()
                .id(UUID.randomUUID())
                .customerName("Deepak Khadka")
                .address("18 Petunia Drive, Apt 2A, North Brunswick, NJ 08902")
                .build();
    }

    @Override
    public CustomerDTO saveNewCustomerDTO(CustomerDTO customerDTO) {
        return CustomerDTO
                .builder()
                .id(UUID.randomUUID())
                .customerName("Deepak Khadka")
                .address("18 Petunia Drive, NJ")
                .build();
    }

    @Override
    public void updateCustomerDTO(UUID customerId, CustomerDTO customerDTO) {
        // todo impl - would add a real imple to update CustomerDTO
    }

    @Override
    public void deleteCustomerDTOById(UUID customerId) {
        log.debug("Deleting a CustomerDTO...");
    }
}
