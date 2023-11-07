package com.example.paymentservice.service;

import com.example.paymentservice.dto.PaymentDto;
import com.example.paymentservice.entity.TransactionDetails;
import com.example.paymentservice.repository.TransactionDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public Long doPayment(PaymentDto paymentDto) {

        TransactionDetails transactionDetails = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentStatus("CREATED")
                .paymentMode(paymentDto.getPaymentMode())
                .amount(paymentDto.getAmount())
                .orderId(paymentDto.getOrderId())
                .referenceNumber(paymentDto.getReferenceNumber())
                .build();

        transactionDetails = transactionDetailsRepository.save(transactionDetails);
        return transactionDetails.getId();
    }
}
