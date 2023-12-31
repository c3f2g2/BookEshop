package com.example.bookeshop.services;

import com.example.bookeshop.models.Basket;
import com.example.bookeshop.models.BasketItem;
import com.example.bookeshop.models.Book;
import com.example.bookeshop.repositories.BasketRepository;
import com.example.bookeshop.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BasketService {

    private final BookRepository bookRepository;
    private final BasketRepository basketRepository;

    public BasketService(BookRepository bookRepository, BasketRepository basketRepository){
        this.bookRepository = bookRepository;
        this.basketRepository = basketRepository;
    }

    public void addToBasket(Long basketId, Book book, int quantity) {
    Basket basket = basketRepository.findById(basketId).orElseThrow(()-> new IllegalArgumentException("Basket not found"));
    BasketItem item = new BasketItem();
    item.setBook(book);
    item.setQuantity(quantity);
    basket.getItems().add(item);
    basketRepository.save(basket);
    }

    public Basket getBasket(Long basketId) {
    return basketRepository.findById(basketId).orElse(null);
    }

    public void removeFromBasket(Long basketId, Long bookId) {
        Basket basket = basketRepository.findById(basketId)
                .orElseThrow(() -> new IllegalArgumentException("Basket not found"));
        basket.setItems(basket.getItems().stream()
                .filter(item -> !item.getBook().getId().equals(bookId))
                .collect(Collectors.toList()));
        basketRepository.save(basket);
    }

    public void clearBasket(Long basketId) {
        Basket basket = basketRepository.findById(basketId).orElseThrow(() -> new IllegalArgumentException("Basket not found"));
        basket.getItems().clear();
        basketRepository.save(basket);
    }




}
