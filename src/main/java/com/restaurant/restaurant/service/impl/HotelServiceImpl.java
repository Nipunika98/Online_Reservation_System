package com.restaurant.restaurant.service.impl;

import com.restaurant.restaurant.entity.Hotel;
import com.restaurant.restaurant.repository.HotelRepository;
import com.restaurant.restaurant.service.HotelServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelServiceInterface {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        // Ensure that `id` is properly handled as a String or adjust as necessary
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel addNewHotel(Hotel hotel) {
        // Ensure that `Hotel` entity has the required fields and validation before saving
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        // Ensure that `Hotel` entity has an `id` field and `findById` returns the entity
        return hotelRepository.findById(hotel.getId())
                .map(existingHotel -> {
                    existingHotel.setName(hotel.getName());
                    existingHotel.setLocation(hotel.getLocation());
                    existingHotel.setOwnerId(hotel.getOwnerId());
                    return hotelRepository.save(existingHotel);
                })
                .orElse(null); // Return null if hotel is not found
    }

    @Override
    public String deleteHotel(String id) {
        // Ensure that `id` is properly handled as a String or adjust as necessary
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return "Hotel deleted successfully";
        } else {
            return "Hotel not found";
        }
    }
}
