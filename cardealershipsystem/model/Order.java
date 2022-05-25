package com.example.cardealershipsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class Order {
    private String id;
    private String userId;
    private String carId;
}
