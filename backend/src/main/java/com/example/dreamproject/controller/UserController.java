package com.example.dreamproject.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.dreamproject.dto.response.UserDetailsResponse;
import com.example.dreamproject.entity.User;
import com.example.dreamproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public List<User> getUser() {
        return userService.getUser();
    }

    @Operation(summary="Get user details by userId")
    @GetMapping("/{id}")
    public UserDetailsResponse getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable String id){
        userService.deleteUserById(id);
    }
    @PutMapping("/")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
}
