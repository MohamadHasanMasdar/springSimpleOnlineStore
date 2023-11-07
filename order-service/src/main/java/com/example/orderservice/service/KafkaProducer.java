package com.example.orderservice.service;

public interface KafkaProducer {

    void sendMessage(String message, String topicName);
}
