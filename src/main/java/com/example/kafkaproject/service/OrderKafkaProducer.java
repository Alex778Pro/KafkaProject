package com.example.kafkaproject.service;

import com.example.kafkaproject.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderKafkaProducer {
    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    private static final Logger logger = LoggerFactory.getLogger(OrderKafkaProducer.class);
    private final KafkaTemplate<String, Order> kafkaTemplate;
    public OrderKafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderKafka(Order order) {
        kafkaTemplate.send(defaultTopic, order);
        logger.info("Order sent to kafka: " + order);
    }
}
