package com.restaurant.restaurant.service;

import java.util.List;
import com.restaurant.restaurant.entity.Booking;

public interface BookingServiceInterface {

    String bookTable(Booking booking);


    List<Booking> getBookingsByHotel_Id(int hotelId);
}
