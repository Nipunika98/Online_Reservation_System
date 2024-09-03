package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.HotelOwner;
import com.restaurant.restaurant.service.HotelOwnerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HotelOwnerController {

    @Autowired
    private HotelOwnerServiceInterface hotelOwnerServiceInterface;

    @GetMapping("/owners")
    public ResponseEntity<List<HotelOwner>> getAllOwners() {
        List<HotelOwner> owners = hotelOwnerServiceInterface.getAllOwners();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<HotelOwner> getOwner(@PathVariable String id) {
        HotelOwner owner = hotelOwnerServiceInterface.getOwner(id);
        if (owner == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(owner);
    }

    @PostMapping("/owners/add")
    public ResponseEntity<HotelOwner> addNewOwner(@RequestBody HotelOwner hotelOwner) {
        HotelOwner newOwner = hotelOwnerServiceInterface.addNewOwner(hotelOwner);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOwner);
    }

    @PutMapping("/owners/update/{id}")
    public ResponseEntity<HotelOwner> updateOwner(@PathVariable String id, @RequestBody HotelOwner hotelOwner) {
        HotelOwner updatedOwner = hotelOwnerServiceInterface.updateOwner(id, hotelOwner);
        if (updatedOwner == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedOwner);
    }

    @DeleteMapping("/owners/delete/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable String id) {
        String result = hotelOwnerServiceInterface.deleteOwner(id);
        if (result.equals("Owner not found")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/owners/login")
    public ResponseEntity<?> loginHotelOwner(@RequestBody HotelOwner hotelOwner) {
        HotelOwner owner = hotelOwnerServiceInterface.loginHotelOwner(hotelOwner);
        if (owner == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
        if (owner.getPassword().equals(hotelOwner.getPassword())) {
            return ResponseEntity.ok(owner);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
        }
    }
}
