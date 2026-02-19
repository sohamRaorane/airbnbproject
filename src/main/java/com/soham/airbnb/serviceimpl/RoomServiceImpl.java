package com.soham.airbnb.serviceimpl;

import com.soham.airbnb.entity.Hotel;
import com.soham.airbnb.entity.Room;
import com.soham.airbnb.exception.ResoucreNotFoundException;
import com.soham.airbnb.repository.HotelRepository;
import com.soham.airbnb.repository.RoomRepository;
import com.soham.airbnb.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;


    @Override
    public Room addRoom(Long hotelId ,Room room){
        Hotel hotel =hotelRepository.findById(hotelId)
                .orElseThrow(() ->new ResoucreNotFoundException(("Hotel Not Found ")));
        room.setHotel(hotel);
        return roomRepository.save(room);

    }
    @Override
    public List<Room > getsRoomsByHotel(Long hotelId){
        return roomRepository.findByHotelId(hotelId);
    }

}
