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
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long totalPrice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BasketItem> items = new ArrayList<>();

    public int calculateTotalPrice() {
        return items.stream()
                .mapToInt(item -> Math.toIntExact(item.getBook().getPrice() * item.getQuantity()))
                .sum();
    }
}


