package com.example.bookeshop.controllers;


import com.example.bookeshop.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    private BookService bookService;

    @GetMapping("/")
    public String MainPage(Model model){
        model.addAttribute("listOfAllBooks", bookService.getAllBooks());
        return "index";
    }
}
