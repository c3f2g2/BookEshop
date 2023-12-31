package com.example.bookeshop.services;

import com.example.bookeshop.models.Basket;
import com.example.bookeshop.models.BasketItem;
import com.example.bookeshop.models.Book;
import com.example.bookeshop.repositories.BasketRepository;
import com.example.bookeshop.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    private final BookRepository bookRepository;
    private final BasketRepository basketRepository;

    private BookService bookService;

    @Autowired
    public PurchaseService(BookRepository bookRepository, BasketRepository basketRepository){
        this.bookRepository = bookRepository;
        this.basketRepository = basketRepository;
    }

    @Transactional
    public void completePurchase(Long basketId) {
        Basket basket = basketRepository.findById(basketId).orElseThrow(null);
        for (BasketItem item : basket.getItems()) {
            Book book = item.getBook();
            Long bookID = book.getId();
            bookService.decreaseQuantityOnStock(bookID, item.getQuantity());
            bookRepository.save(book);
        }
        // Clear the basket or handle it as per your logic
    }


}
