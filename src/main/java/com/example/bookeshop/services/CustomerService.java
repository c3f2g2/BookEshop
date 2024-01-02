package com.example.bookeshop.services;

import com.example.bookeshop.models.Customer;
import com.example.bookeshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public void addNewCustomer(String userName, String email, String password){
        Customer customer = new Customer(userName, email, password);
        customerRepository.save(customer);

    }
}
