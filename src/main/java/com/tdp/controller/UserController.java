package com.tdp.controller;

import com.tdp.exception.UserNotFoundException;
import com.tdp.model.User;
import com.tdp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    public Optional<User> getUserById(Long id){
        return userService.getUserById(id);
    }
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    public User createUser(User user){
        return userService.createUser(user);
    }
    public User updateUser(Long id, User updateUser) throws UserNotFoundException {
        return userService.updateUser(id,updateUser);
    }
    public void deleteUser(Long id){
        userService.deleteUser(id);
    }
}
