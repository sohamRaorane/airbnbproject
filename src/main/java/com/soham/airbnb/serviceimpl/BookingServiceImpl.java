package com.soham.airbnb.serviceimpl;


import com.soham.airbnb.entity.Booking;
import com.soham.airbnb.entity.BookingStatus;
import com.soham.airbnb.entity.Room;
import com.soham.airbnb.entity.User;
import com.soham.airbnb.repository.BookingRepository;
import com.soham.airbnb.repository.RoomRepository;
import com.soham.airbnb.repository.UserRepository;
import com.soham.airbnb.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl  implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    @Override
    public Booking createBooking (Long userId, Long roomId, LocalDate checkIn, LocalDate checkOut){
        User user =userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not found "));

        Room room =roomRepository.findById(roomId).orElseThrow(() -> new RuntimeException("Room Not found "));



        List<Booking > overlapping =bookingRepository.findOverlappingBookings(roomId , checkIn ,checkOut );
        if(!overlapping.isEmpty()){
            throw new RuntimeException("Room not available for the selected dates ");

        }
        Booking booking =new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setCheckInDate(checkIn );
        booking.setCheckOutDate(checkOut);
        booking.setStatus(BookingStatus.PENDING);




        return bookingRepository.save(booking);

    }
    @Override
    public List<Booking> getUserBookings(Long userId){
        return bookingRepository.findByUserId(userId);
    }



}
