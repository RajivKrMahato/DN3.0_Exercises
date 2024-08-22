package com.bookstore.api.controller;

import com.bookstore.api.model.Customer;
import com.bookstore.api.dto.CustomerDTO;
import com.bookstore.api.mapper.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public Customer createCustomer(@RequestBody Customer customer) {
//        return customer;
//    }
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
        // Save customer to DB (not implemented in this example)
        return CustomerMapper.INSTANCE.customerToCustomerDTO(customer);
    }
    
    @PostMapping("/register")
    public String registerCustomer(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String address) {
        return "Customer registered with name: " + name;
    }

}