package com.example.bookeshop.services;

import com.example.bookeshop.models.Author;
import com.example.bookeshop.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public void addAuthor(String name){
        Author author = new Author(name);
        authorRepository.save(author);
    }
}
