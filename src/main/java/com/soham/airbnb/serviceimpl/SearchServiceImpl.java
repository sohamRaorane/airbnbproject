package com.soham.airbnb.serviceimpl;


import com.soham.airbnb.entity.Hotel;
import com.soham.airbnb.repository.HotelRepository;
import com.soham.airbnb.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final HotelRepository hotelRepository;


    public List<Hotel> searchHotels(String city){
        return hotelRepository.findByCityIgnoreCase(city);
    }

}
