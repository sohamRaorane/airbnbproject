package com.soham.airbnb.service;

import com.soham.airbnb.entity.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    Booking createBooking(Long userId , Long roomId, LocalDate checkIn , LocalDate checkOut);
    List<Booking > getUserBookings(Long userId);
}
