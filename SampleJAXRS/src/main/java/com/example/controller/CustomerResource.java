package com.example.controller;

import com.example.dao.CustomerRepository;
import com.example.model.Customer;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/customers")
public class CustomerResource {

    private CustomerRepository customerRepository = new CustomerRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
