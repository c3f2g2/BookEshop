package com.example.bookeshop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class PurchaseController {

    @PostMapping("/proceed-purchase")
    public String proceedPurchase() {

        return "purchaseProceeding";
    }

    @PostMapping("/purchase-confirmation")
    public String purchaseConfirmation(){
        return "purchaseConfirmation";
    }
}
