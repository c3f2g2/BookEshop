package com.example.bookeshop.services;

import com.example.bookeshop.models.Basket;
import com.example.bookeshop.models.BasketItem;
import com.example.bookeshop.models.Book;
import com.example.bookeshop.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public Basket addToBasket(Long basketId, Book book, int quantity) {
    Basket basket = basketRepository.findById(basketId).orElse(null);
    BasketItem item= new BasketItem();
    item.setBook(book);
    item.setQuantity(quantity);
    return basketRepository.save(basket);
    }

    public Basket getBasket(Long basketId) {
    return basketRepository.findById(basketId).orElse(null);
    }
}
