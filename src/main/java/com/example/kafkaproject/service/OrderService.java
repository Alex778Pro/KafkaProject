package com.example.kafkaproject.service;

import com.example.kafkaproject.entity.Order;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OrderService {

    private static final Logger logger = Logger.getLogger(OrderService.class.getName());

    private final OrderKafkaProducer orderKafkaProducer;
    public OrderService(OrderKafkaProducer orderKafkaProducer) {
        this.orderKafkaProducer = orderKafkaProducer;
    }
    public void createOrder(Order order) {
        //Сохранение в базу
        orderKafkaProducer.sendOrderKafka(order);
        logger.info("Order created id: " + order.getOrderId());
    }
}
