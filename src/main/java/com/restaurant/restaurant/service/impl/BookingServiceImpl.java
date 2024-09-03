package com.restaurant.restaurant.service.impl;

import java.util.List;

import com.restaurant.restaurant.service.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.restaurant.entity.Booking;
import com.restaurant.restaurant.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public String bookTable(Booking booking) {
        try {
            bookingRepository.save(booking);
            return "Booking successful!";
        } catch (Exception e) {
            throw new RuntimeException("Failed to book table: " + e.getMessage());
        }
    }

    @Override
    public List<Booking> getBookingsByHotel_Id(int hotelId) {
        return bookingRepository.findByHotelId(hotelId);
    }
}
