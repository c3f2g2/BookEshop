package com.example.bookeshop.controllers;

import com.example.bookeshop.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

    private CustomerService customerService;
    @GetMapping("/registration")
    public String registration(){
        return "register";
    }

    @PostMapping("/registration")
    public String registrationForm(@RequestBody String name, @RequestBody String email, @RequestBody String password){
        customerService.addNewCustomer(name, email, password);
        return "redirect:/";
    }
}
