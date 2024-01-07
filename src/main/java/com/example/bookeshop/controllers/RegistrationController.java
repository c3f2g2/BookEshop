package com.example.bookeshop.controllers;

import com.example.bookeshop.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private CustomerService customerService;
    @GetMapping("/registration")
    public String registration(){
        return "register";
    }

    @PostMapping("/registration")
    public String registrationForm(@RequestParam("username") String name,
                                   @RequestParam("email") String email,
                                   @RequestParam ("passwordToRegister")String password){
        customerService.addNewCustomer(name, email, password);
        return "redirect:/";
    }
}
