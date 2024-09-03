package com.restaurant.restaurant.service;

import com.restaurant.restaurant.entity.NonVegMenu;

import java.util.List;

public interface NonVegMenuServiceInterface {
    List<NonVegMenu> getAllNonVegMenus();
    NonVegMenu getNonVegMenu(String id);
    NonVegMenu addNewNonVegMenu(NonVegMenu nonVegMenu);
    NonVegMenu updateNonVegMenu(String id, NonVegMenu nonVegMenu);
    String deleteNonVegMenu(String id);
    List<NonVegMenu> getHotelNonVegMenu(String hotelId);
}
