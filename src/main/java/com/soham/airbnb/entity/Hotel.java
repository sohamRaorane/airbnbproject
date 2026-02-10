package com.soham.airbnb.entity;




import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String city ;
    private String address;

    @ManyToOne
    @JoinColumn(name ="owner_id")
    private User owner;



}
