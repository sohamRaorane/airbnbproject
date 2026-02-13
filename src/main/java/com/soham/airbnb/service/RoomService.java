package com.soham.airbnb.service;

import com.soham.airbnb.entity.Room;

import java.util.List;

public interface RoomService {
    Room addRoom (Long hotelId, Room room);
    List<Room> getsRoomsByHotel(Long hotelId);

}
