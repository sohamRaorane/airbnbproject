package com.soham.airbnb.service;

import com.soham.airbnb.entity.Hotel;

import java.util.List;

public interface SearchService {
    List<Hotel> searchHotels(String city);
}
