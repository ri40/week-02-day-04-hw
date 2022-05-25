package com.example.cardealershipsystem.controllers;

import com.example.cardealershipsystem.model.Api;
import com.example.cardealershipsystem.model.Car;
import com.example.cardealershipsystem.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/car")
public class CarController {

    private final CarService carService;


    @GetMapping
    public ResponseEntity <ArrayList<Car>> getCar(){
        return ResponseEntity.status(200).body(carService.getCar());
    }

    @PostMapping
    public ResponseEntity<Api> addCar(@RequestBody @Valid Car car, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }

        boolean isCarAdded =carService.addCar(car);
        if (!isCarAdded){
            return ResponseEntity.status(500).body(new Api("Error adding a car",500));

        }
        return ResponseEntity.status(200).body(new Api("New car added",200));
    }
    @PutMapping("/bey")
    public ResponseEntity<Api> beyCar(@RequestParam String userId,@RequestParam String carId ,@RequestParam Integer price){
        Integer beyStatus=carService.byCar(userId,carId,price);
        switch (beyStatus){
            case -1:
                return ResponseEntity.status(400).body(new Api("Userid is not valid",400));
            case 0:
                return ResponseEntity.status(400).body(new Api("Carid is not valid",400));
            case 1:
                return ResponseEntity.status(400).body(new Api("Price is not enough",400));
            case 2:
                return ResponseEntity.status(200).body(new Api("Car purchase",200));
            default:
                return ResponseEntity.status(500).body(new Api("Server error",500));

        }
    }
}
