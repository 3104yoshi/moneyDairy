package com.example.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemPriceController {

    @GetMapping("/getTotalPrice")
    public int getTotalPrice() {
        return 1;
    }
}
