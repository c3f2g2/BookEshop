package com.example.bookeshop.controllers;

import com.example.bookeshop.models.Basket;
import com.example.bookeshop.models.BasketItem;
import com.example.bookeshop.models.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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



}
