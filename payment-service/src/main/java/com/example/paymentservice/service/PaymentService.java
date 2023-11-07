package com.example.paymentservice.service;

import com.example.paymentservice.dto.PaymentDto;

public interface PaymentService {

    Long doPayment(PaymentDto paymentDto);
}
