package com.soham.airbnb.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private LocalDate checkInDate;
    private LocalDate  checkOutDate ;



    @Enumerated(EnumType.STRING )
    private BookingStatus status;

    @ManyToOne
    private User user ;

    @ManyToOne
    private Room room;



}
