package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    // Custom query to find hotels by name
    List<Hotel> findByName(String name);

    // Custom query to find hotels by location
    List<Hotel> findByLocation(String location);

    // Custom query to find hotels by owner ID
    List<Hotel> findByOwnerId(String ownerId);
}

