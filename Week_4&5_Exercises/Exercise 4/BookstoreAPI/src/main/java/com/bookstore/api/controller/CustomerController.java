package com.bookstore.api.controller;

import com.bookstore.api.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customer;
    }
    
    @PostMapping("/register")
    public String registerCustomer(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String address) {
        return "Customer registered with name: " + name;
    }

}