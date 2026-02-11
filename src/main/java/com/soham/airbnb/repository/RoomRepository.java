package com.soham.airbnb.repository;


import com.soham.airbnb.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long > {

    List<Room> findByHotelId(Long hotelID);

}
//fetch the room of the hotel and Used by both the admin and guest flow
