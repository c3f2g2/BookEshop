package com.example.bookeshop.services;


import com.example.bookeshop.dtos.SearchResultDTO;
import com.example.bookeshop.models.Author;
import com.example.bookeshop.models.Book;
import com.example.bookeshop.repositories.AuthorRepository;
import com.example.bookeshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {


    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public SearchService(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<SearchResultDTO> search(String query) {
        List<Book> books = bookRepository.findByNameContainingIgnoreCase(query);
        List<Author> authors = authorRepository.findByNameContainingIgnoreCase(query);

        List<SearchResultDTO> results = new ArrayList<>();
        for (Book book : books) {
            results.add(convertToDTO(book, "Book"));
        }
        for (Author author : authors) {
            results.add(convertToDTO(author, "Author"));
        }
        return results;
    }

    private SearchResultDTO convertToDTO(Book book, String type) {
        return new SearchResultDTO(book.getName(), type, book.getId());
    }

    private SearchResultDTO convertToDTO(Author author, String type) {
        return new SearchResultDTO(author.getName(), type, author.getId());
    }
}

