package com.example.db.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Item.Key> {
    List<Item> findAllByKeyCategory(String category);
}
