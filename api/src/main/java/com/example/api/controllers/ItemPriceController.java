package com.example.api.controllers;

import com.example.calculator.ItemPriceCalculator;
import com.example.db.item.Item;
import com.example.db.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.api.ItemPostRequest;

import java.util.Map;

@RestController
public class ItemPriceController {

    private final ItemPriceCalculator itemPriceCalculator;

    private final ItemRepository itemRepository;

    @Autowired
    public ItemPriceController(
            ItemPriceCalculator itemPriceCalculator,
            ItemRepository itemRepository) {
        this.itemPriceCalculator = itemPriceCalculator;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/getTotalPrice")
    @CrossOrigin(origins = "http://localhost:8081")
    public Map<String, Integer> getTotalPrice() {
        return Map.of("totalPrice", itemPriceCalculator.fetchTotalAmount());
    }

    @GetMapping("/getTotalPriceByCategory")
    public Integer getTotalPriceByCategory(@RequestBody String category) {
        return itemPriceCalculator.fetchTotalAmountByCategory(category);
    }

    @PostMapping("/postNewItem")
    public Item postNewItem(@RequestParam Item item) {
        return itemRepository.save(item);
    }

    @PostMapping("/addPrice")
    @CrossOrigin(origins = "http://localhost:8081")
    public Item addPrice(@RequestBody ItemPostRequest itemPostRequest) {
        System.out.println(itemPostRequest.getCategory());
        System.out.println(itemPostRequest.getDate());
        System.out.println(itemPostRequest.getPrice());
        Item item = itemRepository.findById(new Item.Key(itemPostRequest.getCategory(), itemPostRequest.getDate())).orElseThrow();
        return itemRepository.save(new Item(item.getKey(), item.getPrice() + itemPostRequest.getPrice()));
    }

}
