package com.example.cardealershipsystem.controllers;

import com.example.cardealershipsystem.model.Api;
import com.example.cardealershipsystem.model.Car;
import com.example.cardealershipsystem.model.Log;
import com.example.cardealershipsystem.service.CarService;
import com.example.cardealershipsystem.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/log")

public class LogController {

    private final LogService logService;
    @GetMapping
    public ResponseEntity<ArrayList<Log>> getLog(){
        return ResponseEntity.status(200).body(logService.getLogs());
    }

    @PostMapping
    public ResponseEntity<Api> addLog(@RequestBody @Valid Log log , Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
       boolean isLogAdded=logService.addlog(log);
        if (!isLogAdded){
            return ResponseEntity.status(500).body(new Api("Invalid car id or user id ",500));
        }
        return ResponseEntity.status(201).body(new Api("Error adding a log",201));
    }
}
