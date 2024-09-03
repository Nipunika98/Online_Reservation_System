package com.restaurant.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restaurant.entity.Booking;
import com.restaurant.restaurant.service.BookingServiceInterface;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

    @Autowired
    private BookingServiceInterface bookingServiceInterface;

    @PostMapping("/bookings")
    public ResponseEntity<String> bookTable(@RequestBody Booking booking) {
        try {
            String result = bookingServiceInterface.bookTable(booking);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to book table: " + e.getMessage());
        }
    }

    @GetMapping("/bookings/{hotelId}")
    public ResponseEntity<List<Booking>> getBookingsByHotelId(@PathVariable int hotelId) {
        try {
            List<Booking> bookings = bookingServiceInterface.getBookingsByHotel_Id(hotelId);
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
