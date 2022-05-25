package com.example.cardealershipsystem.service;

import com.example.cardealershipsystem.model.Car;
import com.example.cardealershipsystem.model.Log;
import com.example.cardealershipsystem.model.Order;
import com.example.cardealershipsystem.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service @RequiredArgsConstructor
public class OrderService {

    private ArrayList<Order> orders= new ArrayList<Order>();
    private final CarService carService;
    private final UserService userService;
    private final LogService logService;
    public ArrayList<Order> getOrders() {
        return orders;
    }
    public boolean addOrder(Order order) {
        User currentUser=userService.getUser(order.getId());
        Car currentCar=carService.getCar(order.getId());
        if (currentUser==null || currentCar==null){
            return false;
        }

        logService.addLog("New order added by"+currentUser.getId()+"To a car"+currentCar.getId());
        return orders.add(order);
    }
}
