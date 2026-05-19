package com.kindergarten.saga.orderservice.service;

import com.kindergarten.saga.core.dto.Order;
import com.kindergarten.saga.core.events.OrderCreateEvent;
import com.kindergarten.saga.core.types.OrderStatus;
import com.kindergarten.saga.orderservice.dao.jpa.entity.OrderEntity;
import com.kindergarten.saga.orderservice.dao.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String orderEventsTopicName;

    public OrderServiceImpl(OrderRepository orderRepository,
                            KafkaTemplate<String, Object> kafkaTemplate,
                            @Value("${orders.events.topic.name}") String orderEventsTopicName
    ) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.orderEventsTopicName = orderEventsTopicName;
    }

    @Override
    public Order placeOrder(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setCustomerId(order.getCustomerId());
        entity.setProductId(order.getProductId());
        entity.setProductQuantity(order.getProductQuantity());
        entity.setStatus(OrderStatus.CREATED);
        orderRepository.save(entity);

        OrderCreateEvent orderEvent = new OrderCreateEvent(
                entity.getId(),
                entity.getCustomerId(),
                entity.getProductId(),
                entity.getProductQuantity()
        );
        kafkaTemplate.send(orderEventsTopicName, orderEvent);

        return new Order(
                entity.getId(),
                entity.getCustomerId(),
                entity.getProductId(),
                entity.getProductQuantity(),
                entity.getStatus());
    }
}
