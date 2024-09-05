package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.Hotel;
import com.restaurant.restaurant.entity.VegMenu;
import com.restaurant.restaurant.service.VegMenuServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class VegMenuController {

    @Autowired
    private VegMenuServiceInterface vegMenuServiceInterface;

    @GetMapping("/vegmenu")
    public ResponseEntity<List<VegMenu>> getAllVegMenus() {
        List<VegMenu> vegMenus = vegMenuServiceInterface.getAllVegMenus();
        return ResponseEntity.ok(vegMenus);
    }

    @GetMapping("/vegmenu/{id}")
    public ResponseEntity<VegMenu> getVegMenu(@PathVariable String id) {
        VegMenu vegMenu = vegMenuServiceInterface.getVegMenu(id);
        if (vegMenu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vegMenu);
    }

    @PostMapping("/vegmenu/add")
    public ResponseEntity<VegMenu> addNewVegMenu(@RequestBody VegMenu vegMenu) {
        VegMenu newVegMenu = vegMenuServiceInterface.addNewVegMenu(vegMenu);
        return ResponseEntity.status(201).body(newVegMenu);
    }

    @PutMapping("/vegmenu/update/{id}")
    public ResponseEntity<VegMenu> updateVegMenu(@PathVariable String id, @RequestBody VegMenu vegMenu) {
        VegMenu updatedVegMenu = vegMenuServiceInterface.updateVegMenu(id, vegMenu);
        if (updatedVegMenu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVegMenu);
    }

    @DeleteMapping("/vegmenu/delete/{id}")
    public ResponseEntity<String> deleteVegMenu(@PathVariable String id) {
        String result = vegMenuServiceInterface.deleteVegMenu(id);
        if (result.equals("VegMenu not found")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/veg-menu")
    public ResponseEntity<List<VegMenu>> getVegMenuForHotel(@RequestBody Hotel hotel) {
        // Use getId() instead of getHotel_id()
        List<VegMenu> vegMenus = vegMenuServiceInterface.getHotelVegMenu(hotel.getId());
        return ResponseEntity.ok(vegMenus);
    }
}
