package com.example.bookeshop;

import com.example.bookeshop.models.Author;
//import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Category;
import com.example.bookeshop.repositories.AuthorRepository;
import com.example.bookeshop.repositories.BookRepository;

import com.example.bookeshop.repositories.CategoryRepository;
import com.example.bookeshop.repositories.CustomerRepository;
import com.example.bookeshop.services.AuthorService;
import com.example.bookeshop.services.BookService;
import com.example.bookeshop.services.CategoryService;
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
    private final AuthorService authorService;

    private final CategoryService categoryService;
    private final BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookEshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Author author1 = authorService.addAuthor("Antoine de Saint-Exupéry");
        authorRepository.save(new Author("Antoine de Saint-Exupéry"));

        categoryRepository.save(new Category("Poetry"));
        categoryRepository.save(new Category("Fantasy"));
        categoryRepository.save(new Category("Adventure"));
        categoryRepository.save(new Category("Romance"));

        Book book1 = bookService.addBook("The Little Prince", 194, 1L);
        Book book2 = bookService.addBook("Resurrection", 308, 2L);
        Book book3 = bookService.addBook("Hamlet", 220, 3L);
        Book book4 = bookService.addBook("Factotum", 278, 4L);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);



    }
}
