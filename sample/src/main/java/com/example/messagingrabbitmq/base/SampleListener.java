package com.example.messagingrabbitmq.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleListener {

    @RabbitListener(queues = BaseRabbitMqInfo.queueName)
    public void receiveMessage(CustomMessage message) {
        log.info("get message : {}", message);
    }
}
