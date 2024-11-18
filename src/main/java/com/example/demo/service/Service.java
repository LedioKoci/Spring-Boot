package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private Repository repository;

    @Autowired
    public void setRepository(Repository repository){
        this.repository = repository;
    }

    public Optional<User> getById(Integer id){
        return repository.findById(id);
    }

    public List<User> getAllUsers(){

        return repository.findAll();
    }

    public void registerUser(User user){
        repository.save(user);
    }

    public void updateUser(User updateUser, User user){

        updateUser.setFirst_name(user.getFirst_name());
        updateUser.setSecond_name(user.getSecond_name());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());

        repository.save(updateUser);
    }

    public void deleteUser(Integer id){

        repository.deleteById(id);
    }

    public void deleteAllUsers(){

        repository.deleteAll();
    }
}
