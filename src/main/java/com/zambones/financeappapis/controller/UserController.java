package com.zambones.financeappapis.controller;

import com.zambones.financeappapis.model.User;
import com.zambones.financeappapis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PutMapping("/edit/{username}")
    public User editUser(@PathVariable String username, @RequestBody User updatedUser) {
        return userService.editUser(username, updatedUser);
    }

    @GetMapping("/authenticate")
    public boolean authenticate(@RequestParam String username, @RequestParam String password) {
        return userService.authenticate(username, password);
    }

}
