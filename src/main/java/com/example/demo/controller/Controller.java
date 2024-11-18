package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private Service service;

    @Autowired
    public void setService(Service service){
        this.service = service;
    }

    @GetMapping("/getUser/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){

        return service.getAllUsers();
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user){
        service.registerUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user){

        User updateUser = service.getById(id).get();

        service.updateUser(updateUser, user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Integer id){

        service.deleteUser(id);
    }

    @DeleteMapping("/deleteAllUsers")
    public void deleteAllUsers(){

        service.deleteAllUsers();
    }
}


