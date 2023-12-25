package com.example.bookeshop;

import com.example.bookeshop.models.Author;
//import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Basket;
import com.example.bookeshop.models.Book;
import com.example.bookeshop.models.Category;
import com.example.bookeshop.repositories.*;

import com.example.bookeshop.services.AuthorService;
import com.example.bookeshop.services.BasketService;
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
    private final BasketRepository basketRepository;

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;
    private final BasketService basketService;

    public static void main(String[] args) {
        SpringApplication.run(BookEshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        authorService.addAuthor("Antoine de Saint-Exupéry");
        basketRepository.save(new Basket());

        categoryRepository.save(new Category("Poetry"));
        categoryRepository.save(new Category("Fantasy"));
        categoryRepository.save(new Category("Adventure"));
        categoryRepository.save(new Category("Romance"));

        Book book1 = bookService.addBook("The Little Prince", 194, 1L, 1L, 299L, 10);
        Book book2 = bookService.addBook("Resurrection", 308, 2L, 1L, 359L,10);
        Book book3 = bookService.addBook("Hamlet", 220, 3L, 1L, 439L,10);
        Book book4 = bookService.addBook("Factotum", 278, 4L, 1L, 199L,10);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);



    }
}
