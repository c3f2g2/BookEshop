package com.example.bookeshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String emailAddress;
    private String password;

    public Customer(String userName, String email, String password) {
        this.username = userName;
        this.emailAddress = email;
        this.password = password;
    }

//    private List<Book> shoppingBasket = new ArrayList<>();


}
