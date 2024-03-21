package com.example.dreamproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dreamproject.dto.response.UserDetailsResponse;
import com.example.dreamproject.models.User;
import com.example.dreamproject.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void addUser(User user){
        userRepo.save(user);
    }

    public List<User> getUser(){
        return userRepo.findAll();
    }

    public UserDetailsResponse getUserById(String id){
        User user=userRepo.findById(id).get();
        UserDetailsResponse userDetailsResponse=new UserDetailsResponse();
        userDetailsResponse.setUserId(user.getId());
        userDetailsResponse.setEmailId(user.getEmail());
        userDetailsResponse.setUsername(user.getName());
        userDetailsResponse.setPhonenumber(user.getPhonenumber());
        userDetailsResponse.setAddress(user.getAddress());
        userDetailsResponse.setImage(user.getImage());
        return userDetailsResponse;
    }

    public void deleteUserById(String id){
        userRepo.deleteById(id);
    }

    public void updateUser(User user){
        userRepo.saveAndFlush(user);
    }
}