package com.example.bookeshop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class PurchaseController {

    @PostMapping("/purchase")
    public void proceedingPurchase(){

    }
}
