package com.soham.airbnb.serviceimpl;


import com.soham.airbnb.entity.Booking;
import com.soham.airbnb.entity.BookingStatus;
import com.soham.airbnb.entity.Payment;
import com.soham.airbnb.exception.ResoucreNotFoundException;
import com.soham.airbnb.repository.BookingRepository;
import com.soham.airbnb.repository.PaymentRepository;
import com.soham.airbnb.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final BookingRepository bookingRepository;
    private final PaymentRepository paymentRepository;


    @Override
    public Payment processPayment(Long bookingId ,Double amount){
        Booking booking =bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResoucreNotFoundException("Booking Not found "));
    Payment payment =new Payment ();
    payment.setBooking(booking );
    payment.setAmount(amount);
    payment.setPaymentStatus("SUCCESS");
    payment.setPaymentMethod("CARD");

    booking.setStatus(BookingStatus.CONFIRMED);
    return paymentRepository.save(payment);
    }
}
