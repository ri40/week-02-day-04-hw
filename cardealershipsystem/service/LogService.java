package com.example.cardealershipsystem.service;

import com.example.cardealershipsystem.model.Car;
import com.example.cardealershipsystem.model.Log;
import com.example.cardealershipsystem.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service @RequiredArgsConstructor
public class LogService {

    private ArrayList<Log> logs= new ArrayList<Log>();
    public ArrayList<Log> getLogs() {
        return logs;
    }

    public boolean addLog (String message){
        Log log=new Log(message);
        return logs.add(log);
    }
}
