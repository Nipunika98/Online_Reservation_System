package com.restaurant.restaurant.service;

import com.restaurant.restaurant.entity.Hotel;

import java.util.List;

public interface HotelServiceInterface {
    List<Hotel> getAllHotels();
    Hotel getHotel(String id);
    Hotel addNewHotel(Hotel hotel);
    Hotel updateHotel(Hotel hotel);
    String deleteHotel(String id);
}
