package com.example.calculator;

import com.example.db.item.Item;
import com.example.db.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPriceCalculator {

    private final ItemRepository repository;

    @Autowired
    public ItemPriceCalculator(ItemRepository repository) {
        this.repository = repository;
    }

    public int fetchTotalAmount() {
        List<Item> items = repository.findAll();
        return items.stream().mapToInt(Item::getPrice).sum();
    }
}
