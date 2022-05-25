package com.example.cardealershipsystem.service;

import com.example.cardealershipsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private ArrayList<User> users =new ArrayList<>();
    public ArrayList<User> getUsers(){
        return users;
    }

    public boolean adduser(User user) {
        return users.add(user);
    }

    public User getUser(String userId) {
        for (User user:users) {
            if (user.getId().equals(userId)){
                return user;
            }
        }
        return null;
    }
}
