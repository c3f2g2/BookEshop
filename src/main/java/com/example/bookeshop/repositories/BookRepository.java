package com.example.bookeshop.repositories;

import com.example.bookeshop.models.Author;
import com.example.bookeshop.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
