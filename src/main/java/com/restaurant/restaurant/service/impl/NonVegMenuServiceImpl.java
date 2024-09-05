package com.restaurant.restaurant.service.impl;

import com.restaurant.restaurant.entity.NonVegMenu;
import com.restaurant.restaurant.repository.NonVegMenuRepository;
import com.restaurant.restaurant.service.NonVegMenuServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NonVegMenuServiceImpl implements NonVegMenuServiceInterface {

    @Autowired
    private NonVegMenuRepository nonVegMenuRepository;

    @Override
    public List<NonVegMenu> getAllNonVegMenus() {
        return nonVegMenuRepository.findAll();
    }

    @Override
    public NonVegMenu getNonVegMenu(String id) {
        return nonVegMenuRepository.findById(id).orElse(null);
    }

    @Override
    public NonVegMenu addNewNonVegMenu(NonVegMenu nonVegMenu) {
        return nonVegMenuRepository.save(nonVegMenu);
    }

    @Override
    public NonVegMenu updateNonVegMenu(String id, NonVegMenu nonVegMenu) {
        NonVegMenu existingNonVegMenu = nonVegMenuRepository.findById(id).orElse(null);
        if (existingNonVegMenu == null) {
            return null;
        }
        existingNonVegMenu.setName(nonVegMenu.getName());
        existingNonVegMenu.setDescription(nonVegMenu.getDescription());
        existingNonVegMenu.setPrice(nonVegMenu.getPrice());
        existingNonVegMenu.setHotelId(nonVegMenu.getHotelId());
        return nonVegMenuRepository.save(existingNonVegMenu);
    }

    @Override
    public String deleteNonVegMenu(String id) {
        NonVegMenu nonVegMenu = nonVegMenuRepository.findById(id).orElse(null);
        if (nonVegMenu == null) {
            return "NonVegMenu not found";
        }
        nonVegMenuRepository.deleteById(id);
        return "NonVegMenu deleted successfully";
    }

    @Override
    public List<NonVegMenu> getHotelNonVegMenu(String hotelId) {
        return nonVegMenuRepository.findByHotelId(hotelId);
    }
}
