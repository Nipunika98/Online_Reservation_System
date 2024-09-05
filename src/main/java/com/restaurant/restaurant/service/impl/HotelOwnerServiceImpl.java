package com.restaurant.restaurant.service.impl;

import com.restaurant.restaurant.entity.HotelOwner;
import com.restaurant.restaurant.repository.HotelOwnerRepository;
import com.restaurant.restaurant.service.HotelOwnerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelOwnerServiceImpl implements HotelOwnerServiceInterface {

    @Autowired
    private HotelOwnerRepository hotelOwnerRepository;

    @Override
    public List<HotelOwner> getAllOwners() {
        return hotelOwnerRepository.findAll();
    }

    @Override
    public HotelOwner getOwner(String id) {
        return hotelOwnerRepository.findById(id).orElse(null);
    }

    @Override
    public HotelOwner addNewOwner(HotelOwner hotelOwner) {
        return hotelOwnerRepository.save(hotelOwner);
    }

    @Override
    public HotelOwner updateOwner(String id, HotelOwner hotelOwner) {  // Update method implementation
        HotelOwner existingOwner = hotelOwnerRepository.findById(id).orElse(null);
        if (existingOwner == null) {
            return null;
        }
        existingOwner.setName(hotelOwner.getName());
        existingOwner.setEmail(hotelOwner.getEmail());
        existingOwner.setPassword(hotelOwner.getPassword());
        return hotelOwnerRepository.save(existingOwner);
    }

    @Override
    public String deleteOwner(String id) {
        HotelOwner owner = hotelOwnerRepository.findById(id).orElse(null);
        if (owner == null) {
            return "Owner not found";
        }
        hotelOwnerRepository.deleteById(id);
        return "Owner deleted successfully";
    }

    @Override
    public HotelOwner loginHotelOwner(HotelOwner hotelOwner) {
        return hotelOwnerRepository.findByEmail(hotelOwner.getEmail());
    }
}
