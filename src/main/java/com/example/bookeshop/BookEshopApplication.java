package com.example.bookeshop;

import com.example.bookeshop.models.Book;
import com.example.bookeshop.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BookEshopApplication implements CommandLineRunner {
    private final BookRepository bookRepository;
    public static void main(String[] args) {
        SpringApplication.run(BookEshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = new Book(1L, "Little Prince", 194);
        bookRepository.save(book1);

    }
}
