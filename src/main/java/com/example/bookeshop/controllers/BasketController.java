package com.example.bookeshop.controllers;

import com.example.bookeshop.models.Basket;
import com.example.bookeshop.models.BasketItem;
import com.example.bookeshop.models.Book;
import com.example.bookeshop.repositories.BookRepository;
import com.example.bookeshop.services.BasketService;
import com.example.bookeshop.services.BookService;
import com.example.bookeshop.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class BasketController {
    private BookService bookService;
    private CategoryService categoryService;
    private BasketService basketService;
    private BookRepository bookRepository;
    @PostMapping("basket/add")
    public String addBookToBasket(@RequestParam("bookId") Long bookID, @RequestParam("quantity") int quantity, Model model){
        Long basketID = 1L; //Fixed basketID for now
        Book book = bookRepository.findById(bookID).orElse(null);
        basketService.addToBasket(basketID, book, quantity);
        return "redirect:/basket";
    }

    @GetMapping("/basket")
    public String viewBasket(Model model) {
        Long basketId = 1L; //Fixed basketID for now
        Basket basket = basketService.getBasket(basketId);
        int totalPrice = basket.calculateTotalPrice();
        model.addAttribute("basket", basket);
        model.addAttribute("totalPrice", totalPrice);
        return "basket";
    }

    @PostMapping("basket/remove")
    public String removeBookFromBasket(@RequestParam("bookId") Long bookId){
        Long basketID = 1L; //Fixed basketID for now
        basketService.removeFromBasket(basketID, bookId);
        return "redirect:/basket";
    }

    @PostMapping("/confirm-purchase")
    public String confirmPurchase(Model model) {
        Long basketId = 1L; // This should be obtained based on the user session or context

        Basket basket = basketService.getBasket(basketId);
        if (basket == null) {
            // Handle error - basket not found
            return "errorPage";
        }

        for (BasketItem item : basket.getItems()) {
            Book book = item.getBook();
            int quantity = item.getQuantity();

            if (book.getQuantityOnStock() < quantity) {
                // Handle insufficient stock scenario
                model.addAttribute("error", "Insufficient stock for " + book.getName());
                return "basket";
            }

            bookService.decreaseQuantityOnStock(book.getId(), quantity);
            bookRepository.save(book);
        }

        // Clear the basket after purchase
//        basketService.clearBasket(basketId);

        // Add any confirmation details to the model
        model.addAttribute("success", "Your purchase has been confirmed!");

        return "purchaseConfirmation"; // Redirect to a confirmation page
    }

}
