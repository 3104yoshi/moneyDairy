package com.example.api.controllers;

import com.example.calculator.ItemPriceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemPriceController {

    private final ItemPriceCalculator itemPriceCalculator;

    @Autowired
    public ItemPriceController(ItemPriceCalculator itemPriceCalculator) {
        System.out.println("create item price controller");
        this.itemPriceCalculator = itemPriceCalculator;
    }

    @GetMapping("/getTotalPrice")
    public int getTotalPrice() {
        System.out.println("get!!");
        return itemPriceCalculator.fetchTotalAmount();
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
