package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.Hotel;
import com.restaurant.restaurant.entity.NonVegMenu;
import com.restaurant.restaurant.service.NonVegMenuServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NonVegMenuController {

    @Autowired
    private NonVegMenuServiceInterface nonVegMenuServiceInterface;

    @GetMapping("/nonvegmenu")
    public ResponseEntity<List<NonVegMenu>> getAllNonVegMenus() {
        List<NonVegMenu> nonVegMenus = nonVegMenuServiceInterface.getAllNonVegMenus();
        return ResponseEntity.ok(nonVegMenus);
    }

    @GetMapping("/nonvegmenu/{id}")
    public ResponseEntity<NonVegMenu> getNonVegMenu(@PathVariable String id) {
        NonVegMenu nonVegMenu = nonVegMenuServiceInterface.getNonVegMenu(id);
        if (nonVegMenu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nonVegMenu);
    }

    @PostMapping("/nonvegmenu/add")
    public ResponseEntity<NonVegMenu> addNewNonVegMenu(@RequestBody NonVegMenu nonVegMenu) {
        NonVegMenu newNonVegMenu = nonVegMenuServiceInterface.addNewNonVegMenu(nonVegMenu);
        return ResponseEntity.status(201).body(newNonVegMenu);
    }

    @PutMapping("/nonvegmenu/update/{id}")
    public ResponseEntity<NonVegMenu> updateNonVegMenu(@PathVariable String id, @RequestBody NonVegMenu nonVegMenu) {
        NonVegMenu updatedNonVegMenu = nonVegMenuServiceInterface.updateNonVegMenu(id, nonVegMenu);
        if (updatedNonVegMenu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedNonVegMenu);
    }

    @DeleteMapping("/nonvegmenu/delete/{id}")
    public ResponseEntity<String> deleteNonVegMenu(@PathVariable String id) {
        String result = nonVegMenuServiceInterface.deleteNonVegMenu(id);
        if (result.equals("NonVegMenu not found")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/nonveg-menu")
    public ResponseEntity<List<NonVegMenu>> getNonVegMenuForHotel(@RequestBody Hotel hotel) {
        List<NonVegMenu> nonVegMenus = nonVegMenuServiceInterface.getHotelNonVegMenu(hotel.getId());
        return ResponseEntity.ok(nonVegMenus);
    }
}
