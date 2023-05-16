package com.alkafol.srmmicroservice.rabbitmq;

import com.alkafol.srmmicroservice.services.cache.ClientsCacheService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {
    private final ClientsCacheService clientsCacheService;

    public RabbitMqListener(ClientsCacheService clientsCacheService) {
        this.clientsCacheService = clientsCacheService;
    }

    @RabbitListener(queues = "client.cache.remove.queue")
    public void getCacheRemoveRequest(String phoneNumber){
        clientsCacheService.remove(phoneNumber);
    }
}
