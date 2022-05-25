package com.example.cardealershipsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @Data
public class User {
    @NotEmpty(message = "id is required !")
    private String id;
    @NotEmpty(message = "id is required !")
    private String username;
    @NotEmpty(message = "id is required !")
    private String password;
    @NotNull(message = "id is required !")
    private Integer balance;
}
