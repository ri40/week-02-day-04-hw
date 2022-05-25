package com.example.cardealershipsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @Data
public class Log {
    @NotEmpty(message = "id is required !")
    private String id;
    private String message;

    public Log(String message) {
        this.message=message;
    }
}
