package com.kapped.msspbrewary.web.mappers;

import com.kapped.msspbrewary.domain.Customer;
import com.kapped.msspbrewary.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer CustomerDTOToCustomer(CustomerDTO dto);
    CustomerDTO CustomerToCustomerDTO(Customer customer);

}
