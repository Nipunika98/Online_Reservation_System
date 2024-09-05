package com.restaurant.restaurant.service;

import com.restaurant.restaurant.entity.HotelOwner;
import java.util.List;

public interface HotelOwnerServiceInterface {
    List<HotelOwner> getAllOwners();
    HotelOwner getOwner(String id);
    HotelOwner addNewOwner(HotelOwner hotelOwner);
    HotelOwner updateOwner(String id, HotelOwner hotelOwner);  // Update method signature
    String deleteOwner(String id);
    HotelOwner loginHotelOwner(HotelOwner hotelOwner);
}
