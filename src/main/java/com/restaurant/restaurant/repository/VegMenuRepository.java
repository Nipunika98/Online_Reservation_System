package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.VegMenu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VegMenuRepository extends MongoRepository<VegMenu, String> {
    List<VegMenu> findByHotelId(String hotelId);
}
