package com.example.cardealershipsystem.service;

import com.example.cardealershipsystem.model.Car;
import com.example.cardealershipsystem.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CarService {

    private ArrayList<Car> cars= new ArrayList<Car>();
    private final UserService userService;
    private final LogService logService;
    public ArrayList<Car> getCar() {
        return cars;
    }

    public boolean addCar(Car car) {
        return cars.add(car);
    }

    public Integer byCar(String userId, String carId, Integer price) {
        User currentUser=userService.getUser(userId);
        Car currentCar=getCar(carId);
        if (currentUser==null){
            return -1;
        }
        if (currentCar==null){
            return 0;
        }
        if (!(price>=currentCar.getPrice())){
            return 1;
        }
        cars.remove(currentCar);

        logService.addLog("The user : "+currentUser.getId()+"Bought the Car : "+currentCar.getId());

        return 2;
    }
    public Car getCar(String carId){
        for (Car car:cars) {
            if(car.getId().equals(carId)){
                return car;
            }
        }
        return null;
    }
}
