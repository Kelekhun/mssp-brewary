package com.kapped.msspbrewary.web.controller;

import com.kapped.msspbrewary.services.CustomerService;
import com.kapped.msspbrewary.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerr(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomreById(customerId),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDTO){

        CustomerDTO savedCustomerDTO = customerService.saveNewCustomerDTO(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/"+savedCustomerDTO.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomerDTO(customerId, customerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerDTOById(customerId);
    }
}