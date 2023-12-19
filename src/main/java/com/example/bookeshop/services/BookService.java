package com.example.bookeshop.services;

import com.example.bookeshop.models.Book;
import com.example.bookeshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book addBook(long id, String name, int numberOfPages){
        return new Book(id, name,numberOfPages);
    }

    public void updateBook(Long id, String newName, int newNumberOfPages){
        Book bookToBeUpdated = bookRepository.findById(id).orElse(null);
        bookToBeUpdated.setName(newName);
        bookToBeUpdated.setNumberOfPages(newNumberOfPages);
        bookRepository.save(bookToBeUpdated);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }



}
