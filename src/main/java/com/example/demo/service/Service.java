package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private UserRepository userRepository;

    @Autowired
    public void setRepository(UserRepository repository){
        this.userRepository = repository;
    }

    public Optional<User> getById(Integer id){
        return userRepository.findById(id);
    }

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

    public void registerUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User updateUser, User user){

        updateUser.setFirst_name(user.getFirst_name());
        updateUser.setSecond_name(user.getSecond_name());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());

        userRepository.save(updateUser);
    }

    public void deleteUser(Integer id){

        userRepository.deleteById(id);
    }

    public void deleteAllUsers(){

        userRepository.deleteAll();
    }
}
