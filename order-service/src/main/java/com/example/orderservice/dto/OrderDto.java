package com.example.orderservice.dto;

import com.example.orderservice.enums.PaymentMode;
import lombok.Builder;
import lombok.Data;
import org.example.dto.productservice.ProductDto;

import java.time.Instant;

@Data
@Builder
public class OrderDto {

    private Long id;
    private Long productId;
    private Long quantity;
    private Instant orderDate;
    private String orderStatus;
    private Long amount;
    private PaymentMode paymentMode;
    private ProductDto productDto;
}
