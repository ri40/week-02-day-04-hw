package com.example.cardealershipsystem.controllers;

import com.example.cardealershipsystem.model.Order;
import com.example.cardealershipsystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")

public class OrderController {

    private OrderService orderService ;

    @GetMapping
    public ResponseEntity <ArrayList<Order>> getOrder(){
        return ResponseEntity.status(200).body(orderService.getOrders());
    }
}
