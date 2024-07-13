package com.sabir.springrabbit.home.consumer;

import com.sabir.springrabbit.home.config.RabbitMQConfig;
import com.sabir.springrabbit.home.dto.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQConsumer {

    @RabbitListener(queues =RabbitMQConfig.QUEUE)
    public void consumeMessage(OrderStatus orderStatus){
        log.info("Message Received" + orderStatus);

    }
}
