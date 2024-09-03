package com.restaurant.restaurant.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurant.entity.Hotel;
import com.restaurant.restaurant.service.HotelServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HotelController {

    @Autowired
    private HotelServiceInterface hotelServiceInterface;

    @GetMapping("/hotels")
    public List<Hotel> getAllHotels() {
        return hotelServiceInterface.getAllHotels();
    }

    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable String id) {
        return hotelServiceInterface.getHotel(id);
    }

    @PostMapping("/hotels/add")
    public Hotel addNewHotel(@RequestBody Hotel hotel) {
        return hotelServiceInterface.addNewHotel(hotel);
    }

    @PutMapping("/hotels/update/{id}")
    public Hotel updateHotel(@RequestBody Hotel hotel) {
        return hotelServiceInterface.updateHotel(hotel);
    }

    @DeleteMapping("/hotels/delete/{id}")
    public String deleteHotel(@PathVariable String id) {
        return hotelServiceInterface.deleteHotel(id);
    }
}
