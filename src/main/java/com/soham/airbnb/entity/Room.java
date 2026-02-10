package com.soham.airbnb.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String roomType;
    private Double pricePerNight ;
    private Integer TotalRooms;


    @ManyToOne
    @JoinColumn(name ="hotel_id ")
    private Hotel hotel ;
}
