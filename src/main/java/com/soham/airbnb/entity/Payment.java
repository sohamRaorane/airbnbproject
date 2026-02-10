package com.soham.airbnb.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    private Double amount ;
    private String paymentMethod ;
    private String paymentStatus;


    @OneToOne
    @JoinColumn(name ="booking_id")
    private Booking boooking;





}
