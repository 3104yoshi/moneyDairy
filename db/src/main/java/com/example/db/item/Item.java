package com.example.db.item;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    @JsonProperty
    private Key key;

    @JsonProperty
    private int price;

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Key implements Serializable {

        private String category;

        private String date;
    }
}



