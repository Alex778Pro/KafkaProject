package com.example.kafkaproject.service;

import com.example.kafkaproject.entity.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OrderKafkaProducer {

    private static final Logger logger = Logger.getLogger(OrderKafkaProducer.class.getName());
    private final KafkaTemplate<String, Order> kafkaTemplate;
    public OrderKafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderKafka(Order order) {
        kafkaTemplate.send("orders", order);
        logger.info("Order sent to kafka: " + order);
    }
}
