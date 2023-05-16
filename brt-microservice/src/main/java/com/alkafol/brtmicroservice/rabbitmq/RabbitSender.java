package com.alkafol.brtmicroservice.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender {
    private final RabbitTemplate rabbitTemplate;

    public RabbitSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendClientCacheRemoveMessage(String phoneNumber) {
        rabbitTemplate.convertAndSend("app.exchange", "client.cache.remove.key", phoneNumber);
    }
}
