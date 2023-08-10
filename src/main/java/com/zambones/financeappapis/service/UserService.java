package com.zambones.financeappapis.service;

import com.zambones.financeappapis.model.User;
import com.zambones.financeappapis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        user.setCreationDate(new Date());
        user.setStatus(User.Status.ACTIVE);
        return userRepository.save(user);
    }

    public User editUser(String username, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(username);
        if(existingUser.isPresent()) {
            User user = existingUser.get();
            updatedUser.setModifiedDate(new Date());
            // updatedUser.setModifiedBy();
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User not found.");
        }
    }

    public boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findById(username);
        if(user.isPresent()) {
            return user.get().getPassword().equals(password);
        }

        return false;
    }

}