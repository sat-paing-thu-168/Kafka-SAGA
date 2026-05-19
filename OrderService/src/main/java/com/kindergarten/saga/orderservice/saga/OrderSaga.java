package com.kindergarten.saga.orderservice.saga;

import com.kindergarten.saga.core.dto.commands.ReserveProductCommand;
import com.kindergarten.saga.core.events.OrderCreateEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics="${orders.events.topic.name}")
public class OrderSaga {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String productCommandsTopicName;

    public OrderSaga(
            KafkaTemplate<String, Object> kafkaTemplate,
            @Value("${products.commands.topic.name}") String productCommandsTopicName
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.productCommandsTopicName = productCommandsTopicName;
    }

    @KafkaHandler
    public void handleEvent(@Payload OrderCreateEvent event) {
        ReserveProductCommand reserveProductCommand = new ReserveProductCommand(
                event.getProductId(),
                event.getProductQuantity(),
                event.getOrderId());
        kafkaTemplate.send(productCommandsTopicName, reserveProductCommand);
    }
}
