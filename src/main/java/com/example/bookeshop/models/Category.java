package com.example.bookeshop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Category")
public class Category {

    @OneToMany(mappedBy = "category")
    private List<Book> listOfBooksInCategory = new ArrayList<>();

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
