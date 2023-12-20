package com.example.bookeshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Author {

    @OneToMany(mappedBy = "author")
    private List<Book> listOfAuthorsBooks = new ArrayList<>();

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Author(String s) {
        this.name = s;
    }
}
