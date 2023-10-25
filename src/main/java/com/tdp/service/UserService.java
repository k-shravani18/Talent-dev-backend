package com.tdp.service;

import com.tdp.exception.UserNotFoundException;
import com.tdp.model.User;
import com.tdp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(Long id, User updateUser) throws UserNotFoundException {
        Optional<User> existingUser =userRepository.findById(id);

        if (existingUser.isPresent()){
            User user=existingUser.get();
            user.setUsername(updateUser.getUsername());
            user.setPassword(updateUser.getPassword());
            return userRepository.save(user);
        }else {
            throw new UserNotFoundException();
        }
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
