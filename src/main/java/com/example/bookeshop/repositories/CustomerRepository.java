package com.example.bookeshop.repositories;

import com.example.bookeshop.models.Author;
import com.example.bookeshop.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
