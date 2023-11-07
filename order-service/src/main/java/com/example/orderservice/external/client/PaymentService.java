package com.example.orderservice.external.client;

import org.example.dto.paymentservice.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE/api/v1/payment")
public interface PaymentService {

    @PostMapping("/doPayment")
    ResponseEntity<Long> doPayment(@RequestBody PaymentDto paymentDto);
}
