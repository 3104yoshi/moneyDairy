package com.example.db.item;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "item")
public class Item {
    @Id
    private Key key;

    private int price;

    @Embeddable
    @Data
    public class Key implements Serializable {
        private String category;
        private String name;
    }
}



