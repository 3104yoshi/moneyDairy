package com.example.db.item;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "item")
public class Item {
    @Id
    private Key key;

    private String name;

    private int price;

    @Embeddable
    @Data
    public class Key implements Serializable {
        private String category;
        private String name;
    }
}



