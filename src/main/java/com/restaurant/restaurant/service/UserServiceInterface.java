package com.restaurant.restaurant.service;

import  com.restaurant.restaurant.entity.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAllUsers();
    User getUser(String id);
    User addNewUser(User user);
    User updateUser(String id, User user);
    String deleteUser(String id);
    User loginUser(User user);
}
