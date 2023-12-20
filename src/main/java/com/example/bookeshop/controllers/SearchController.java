//package com.example.bookeshop.controllers;
//
//import com.example.bookeshop.dtos.SearchResultDTO;
//import com.example.bookeshop.services.SearchService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/search")
//public class SearchController {
//
//    @Autowired
//    private SearchService searchService;
//
//    @GetMapping
//    public ResponseEntity<?> search(@RequestParam String query) {
//        // Assuming you have a DTO to combine book and author results
//        List<SearchResultDTO> results = searchService.search(query);
//        return ResponseEntity.ok(results);
//    }
//}
//
