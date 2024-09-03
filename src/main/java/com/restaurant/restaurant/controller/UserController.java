package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userServiceInterface.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userServiceInterface.getUser(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/users/register")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        User newUser = userServiceInterface.addNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        User updatedUser = userServiceInterface.updateUser(id, user);
        if (updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        String result = userServiceInterface.deleteUser(id);
        if (result.equals("User not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/users/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User obj = userServiceInterface.loginUser(user);
        if (obj == null || !obj.getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
        return ResponseEntity.ok(obj);
    }
}
