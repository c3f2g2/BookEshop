package com.example.bookeshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book")
public class Book {

    @ManyToOne
    private Author author;


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int numberOfPages;


    public Book(long l, String littlePrince, int i) {
        this.id = l;
        this.name = littlePrince;
        this.numberOfPages = i;
    }
}
