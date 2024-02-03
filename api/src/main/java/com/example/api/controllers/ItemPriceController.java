package com.example.api.controllers;

import com.example.calculator.ItemPriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ItemPriceController {

    private final ItemPriceCalculator itemPriceCalculator;

    @Autowired
    public ItemPriceController(ItemPriceCalculator itemPriceCalculator) {
        this.itemPriceCalculator = itemPriceCalculator;
    }

    @GetMapping("/getTotalPrice")
    public Map<String, Integer> getTotalPrice() {
        return Map.of("totalPrice", itemPriceCalculator.fetchTotalAmount());
    }

    @GetMapping("/getTotalPriceByCategory")
    public Map<String, Integer> getTotalPriceByCategory(@RequestParam String category) {
        return Map.of("totalPriceByCategory", itemPriceCalculator.fetchTotalAmountByCategory(category));
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
