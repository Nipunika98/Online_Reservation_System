package com.restaurant.restaurant.repository;

import com.restaurant.restaurant.entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {


    List<Booking> findByHotelId(int hotelId);
}
