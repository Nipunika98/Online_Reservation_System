package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.HotelOwner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelOwnerRepository extends MongoRepository<HotelOwner, String> {
    HotelOwner findByEmail(String email);
}
