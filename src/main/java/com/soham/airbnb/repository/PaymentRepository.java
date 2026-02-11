package com.soham.airbnb.repository;

import com.soham.airbnb.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment ,Long > {
    Optional<Payment> findByBooking_Id(Long bookingId);

}
//Check payment status for the booking
//Prevent duplicate Bookings