package com.example.kafkaproject.controller;

import com.example.kafkaproject.entity.Order;
import com.example.kafkaproject.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RequestMapping(path = "/order")
@RestController
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }
}
