package com.spring.rabbitmq.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rabbitmq.config.MessageConfig;
import com.spring.rabbitmq.model.Order;
import com.spring.rabbitmq.model.OrderStatus;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;
    
    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        // Restaurant Service
        // Payment Service
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "Order placed successfully in " + restaurantName);
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, orderStatus);
        return "Success!!";
    }
}
