package com.example.bookeshop.controllers;


import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Category;
import com.example.bookeshop.repositories.BookRepository;
import com.example.bookeshop.services.BasketService;
import com.example.bookeshop.services.BookService;
import com.example.bookeshop.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MainController {
    private BookService bookService;
    private CategoryService categoryService;
    private BasketService basketService;
    private BookRepository bookRepository;

    @GetMapping("/")
    public String MainPage(Model model){
        model.addAttribute("listOfAllBooks", bookService.getAllBooks());
        model.addAttribute("listOfAllCategories", categoryService.listOfAllBooksInCategory());
        return "index";
    }





}
