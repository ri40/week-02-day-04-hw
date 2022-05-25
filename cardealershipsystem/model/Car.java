package com.example.cardealershipsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@AllArgsConstructor @Data
public class Car {
    @NotEmpty(message = "id is required !")
    private String id;
    @NotEmpty(message = "the type of car is required !")
    private String carType;
    @NotEmpty(message = "model is required !")
    private String model;
    @NotEmpty(message = "stock is required !")
    private String stock;
    @NotEmpty(message = "price is required !")
    private Integer price;
    private ArrayList<Car> carOwned;

}
