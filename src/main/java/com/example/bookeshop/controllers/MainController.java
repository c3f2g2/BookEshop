package com.example.bookeshop.controllers;


import com.example.bookeshop.models.Category;
import com.example.bookeshop.services.BookService;
import com.example.bookeshop.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class MainController {
    private BookService bookService;
    private CategoryService categoryService;

    @GetMapping("/")
    public String MainPage(Model model){
        model.addAttribute("listOfAllBooks", bookService.getAllBooks());
        model.addAttribute("listOfAllCategories", categoryService.listOfAllBooksInCategory());
        return "index";
    }

//    @GetMapping("/category/{id}")
//@GetMapping("/category/{id:[\\d]+}")
//    public String GivenCategoryOfBooks(@PathVariable Long id,  Model model){
//        Category category = categoryService.getCategoryById(id);
//        model.addAttribute("listOfAllBooksInCategory", categoryService.listOfAllBooksInCategory());
//        model.addAttribute("listOfAllCategories", categoryService.listOfAllBooksInCategory());
//        return "category";
//    }

}
