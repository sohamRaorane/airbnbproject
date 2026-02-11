package com.soham.airbnb.repository;

import com.soham.airbnb.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking ,Long > {

    List<Booking > findByUserId(Long userId);

    @Query("Select b from Booking b where b.room.id=:roomId and  b.status='CONFIRMED' and (b.checkInDate<:checkOutDate and b.checkOutDate >:checkInDate )")



    List<Booking> findOverlappingBookings(
            @Param("roomId") Long roomID,
            @Param ("checkInDate")LocalDate checkInDate,
            @Param ("checkOutDate")LocalDate checkOutDate
            );


}
//This logic prevents:
//Double Booking
//OverLapping reservations


//General Rules :
//Repository,  only talks to the db
//no business rule
//no dtos
//no service, components
//Extend JpaRepositroy
//Method name should read like english