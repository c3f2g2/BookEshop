package com.example.bookeshop.services;

import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Category;
import com.example.bookeshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;


    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listOfAllBooksInCategory (){
        return categoryRepository.findAll();
    }

    public Long numberOfBooksInCategory (CategoryRepository categoryRepository){
        return categoryRepository.count();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.getReferenceById(id);
    }

    public List<Book> getBooksByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            return category.getListOfBooksInCategory();
        }
        return new ArrayList<>();
    }

}
