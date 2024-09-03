package com.restaurant.restaurant.repository;


import com.restaurant.restaurant.entity.NonVegMenu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NonVegMenuRepository extends MongoRepository<NonVegMenu, String> {
    List<NonVegMenu> findByHotelId(String hotelId);
}
