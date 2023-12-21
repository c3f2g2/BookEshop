package com.example.bookeshop;

import com.example.bookeshop.models.Author;
//import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Category;
import com.example.bookeshop.repositories.AuthorRepository;
import com.example.bookeshop.repositories.BookRepository;

import com.example.bookeshop.repositories.CategoryRepository;
import com.example.bookeshop.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class BookEshopApplication implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CustomerRepository customerRepository;
    private final CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookEshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        bookRepository.save(new Book(1L, "The Little Prince", 194));
//        Author author1 = new Author("Antoine de Saint-Exupéry");
//        authorRepository.save(author1);

        categoryRepository.save(new Category("Poetry"));
        categoryRepository.save(new Category("Fantasy"));
        categoryRepository.save(new Category("Adventure"));
        categoryRepository.save(new Category("Romance"));

    }
}
