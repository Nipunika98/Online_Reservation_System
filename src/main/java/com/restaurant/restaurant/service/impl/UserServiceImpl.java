package com.restaurant.restaurant.service.impl;

import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.repository.UserRepository;
import com.restaurant.restaurant.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null;
        }
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    @Override
    public String deleteUser(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "User not found";
        }
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    @Override
    public User loginUser(User user) {
        return userRepository.findByEmail(user.getEmail());
    }
}
