package com.restaurant.restaurant.service.impl;

import com.restaurant.restaurant.entity.VegMenu;
import com.restaurant.restaurant.repository.VegMenuRepository;
import com.restaurant.restaurant.service.VegMenuServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegMenuServiceImpl implements VegMenuServiceInterface {

    @Autowired
    private VegMenuRepository vegMenuRepository;

    @Override
    public List<VegMenu> getAllVegMenus() {
        return vegMenuRepository.findAll();
    }

    @Override
    public VegMenu getVegMenu(String id) {
        return vegMenuRepository.findById(id).orElse(null);
    }

    @Override
    public VegMenu addNewVegMenu(VegMenu vegMenu) {
        return vegMenuRepository.save(vegMenu);
    }

    @Override
    public VegMenu updateVegMenu(String id, VegMenu vegMenu) {
        VegMenu existingVegMenu = vegMenuRepository.findById(id).orElse(null);
        if (existingVegMenu == null) {
            return null;
        }
        existingVegMenu.setName(vegMenu.getName());
        existingVegMenu.setDescription(vegMenu.getDescription());
        existingVegMenu.setPrice(vegMenu.getPrice());
        existingVegMenu.setHotelId(vegMenu.getHotelId());
        return vegMenuRepository.save(existingVegMenu);
    }

    @Override
    public String deleteVegMenu(String id) {
        VegMenu vegMenu = vegMenuRepository.findById(id).orElse(null);
        if (vegMenu == null) {
            return "VegMenu not found";
        }
        vegMenuRepository.deleteById(id);
        return "VegMenu deleted successfully";
    }

    @Override
    public List<VegMenu> getHotelVegMenu(String hotelId) {
        return vegMenuRepository.findByHotelId(hotelId);
    }
}
