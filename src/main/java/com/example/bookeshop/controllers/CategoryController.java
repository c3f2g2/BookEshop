package com.example.bookeshop.controllers;

import com.example.bookeshop.models.Book;
import com.example.bookeshop.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public String viewCategory(@PathVariable("id") Long categoryId, Model model) {
        List<Book> books = categoryService.getBooksByCategoryId(categoryId);
        model.addAttribute("books", books);
        model.addAttribute("listOfAllCategories", categoryService.listOfAllBooksInCategory());
        return "category";
    }
}
