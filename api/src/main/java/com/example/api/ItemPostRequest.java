package com.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemPostRequest {
    @JsonProperty
    private String category;
    @JsonProperty
    private String date;
    @JsonProperty
    private Integer price;
}
