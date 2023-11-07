package org.example.dto.paymentservice;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PaymentDto {

    private Long orderId;
    private String referenceNumber;
    private String paymentMode;
    private Long amount;
}
