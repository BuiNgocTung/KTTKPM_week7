package com.example.controllers;

import com.example.entities.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public  List<User> getListUser(){
        return  userService.getListUser();
    }
    @GetMapping("/users/{id}")
    public   User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
}
