package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.service.KafkaProducer;
import com.example.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.example.commons.KafkaTopicNames;
import org.example.endpoints.product.OrderControllerEndPoints;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final KafkaProducer kafkaProducer;

    @PostMapping(OrderControllerEndPoints.PATH_PLACE_ORDER)
    public ResponseEntity<Long> placeOrder(@RequestBody OrderDto orderDto) {
        Long orderId = orderService.placeOrder(orderDto);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

    @GetMapping("/getOrderDetails/{id}")
    public ResponseEntity<OrderDto> getOrderDetails(@PathVariable Long id) {
        OrderDto orderDto = orderService.getOrderDetails(id);
        return new ResponseEntity<>(
                orderDto,
                HttpStatus.OK
        );
    }

    @GetMapping("/testNotif")
    public ResponseEntity testNotif() {
        kafkaProducer.sendMessage(
                "order is done. please send email",
                KafkaTopicNames.TOPIC_SEND_EMAIL);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
