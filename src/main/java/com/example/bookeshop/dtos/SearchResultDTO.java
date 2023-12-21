package com.example.bookeshop.dtos;



public class SearchResultDTO {
    private  String name;
    private String type;
    private  Long id;

    public SearchResultDTO(String name, String type, Long id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }
}
