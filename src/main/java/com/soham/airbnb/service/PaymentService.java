package com.soham.airbnb.service;

import com.soham.airbnb.entity.Payment;

public interface PaymentService {
    Payment processPayment (Long bookingId ,Double amount);

}
