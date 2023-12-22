package com.example.bookeshop.services;

import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Category;
import com.example.bookeshop.repositories.BookRepository;
import com.example.bookeshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookService (BookRepository bookRepository, CategoryRepository categoryRepository){
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public Book addBook(String name, int numberOfPages, Long categoryID){
        Category category = categoryRepository.findById(categoryID).orElse(null);
        Book book = new Book(name,numberOfPages);
        book.setCategory(category);
        return book;
    }

    public void updateBook(Long id, String newName, int newNumberOfPages, Long categoryID){
        Book bookToBeUpdated = bookRepository.findById(id).orElse(null);
        Category category = categoryRepository.findById(categoryID).orElse(null);
        bookToBeUpdated.setName(newName);
        bookToBeUpdated.setNumberOfPages(newNumberOfPages);
        bookToBeUpdated.setCategory(category);
        bookRepository.save(bookToBeUpdated);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getSingleBook(Long id){
        return bookRepository.getReferenceById(id);
    }



}
