package com.soham.airbnb.service;

import com.soham.airbnb.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Long ownerId , Hotel hotel  );
    List<Hotel> getHotelsByCity(String city );
}
