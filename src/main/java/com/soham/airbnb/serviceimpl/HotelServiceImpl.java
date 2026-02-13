package com.soham.airbnb.serviceimpl;


import com.soham.airbnb.entity.Hotel;
import com.soham.airbnb.entity.User;
import com.soham.airbnb.repository.HotelRepository;
import com.soham.airbnb.repository.UserRepository;
import com.soham.airbnb.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final UserRepository userRepository;


    public Hotel createHotel(Long ownerId, Hotel hotel){
        User owner=userRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("Owner Not Found "));
        hotel.setOwner(owner);
        return hotelRepository.save(hotel);

    }
    @Override
    public List<Hotel>getHotelsByCity (String city){
        return hotelRepository.findByCityIgnoreCase(city);
    }

}
