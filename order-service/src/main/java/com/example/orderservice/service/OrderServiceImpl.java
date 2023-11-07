package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.NotFoundException;
import com.example.orderservice.external.client.PaymentService;
import com.example.orderservice.external.client.ProductService;
import com.example.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.example.dto.paymentservice.PaymentDto;
import org.example.dto.productservice.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final PaymentService paymentService;

    @Override
    @Transactional
    public Long placeOrder(OrderDto orderDto) {

        productService.reduceProductQuantity(
                orderDto.getProductId(), orderDto.getQuantity());

        Order order = Order.builder()
                .orderDate(Instant.now())
                .orderStatus("CREATED")
                .amount(orderDto.getAmount())
                .quantity(orderDto.getQuantity())
                .productId(orderDto.getProductId())
                .build();

        order = orderRepository.save(order);


        String orderStatus = null;
        try {
            PaymentDto paymentDto = PaymentDto.builder()
                    .orderId(order.getId())
                    .paymentMode(orderDto.getPaymentMode().name())
                    .amount(orderDto.getAmount())
                    .build();

            paymentService.doPayment(paymentDto);
            orderStatus = "PLACED";
        } catch (Exception e) {
            orderStatus = "PAYMENT_FAILED";
        }

        order.setOrderStatus(orderStatus);
        order = orderRepository.save(order);
        return order.getId();
    }

    @Override
    public OrderDto getOrderDetails(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("order not found with id: " + id));

        ProductDto productDto = productService.getProductById(order.getProductId()).getBody();

        return OrderDto.builder()
                .orderDate(order.getOrderDate())
                .orderStatus(order.getOrderStatus())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .amount(order.getAmount())
                .productDto(productDto)
                .build();

    }
}
