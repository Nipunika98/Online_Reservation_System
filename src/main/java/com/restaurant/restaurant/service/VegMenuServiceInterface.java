package com.restaurant.restaurant.service;

import com.restaurant.restaurant.entity.VegMenu;

import java.util.List;

public interface VegMenuServiceInterface {
    List<VegMenu> getAllVegMenus();
    VegMenu getVegMenu(String id);
    VegMenu addNewVegMenu(VegMenu vegMenu);
    VegMenu updateVegMenu(String id, VegMenu vegMenu);
    String deleteVegMenu(String id);
    List<VegMenu> getHotelVegMenu(String hotelId);
}
