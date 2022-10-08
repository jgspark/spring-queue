package com.example.messagingrabbitmq.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleListener {

    @RabbitListener(queues = RabbitMaConfiguration.queueName)
    public void receiveMessage(CustomMessage message) {
        log.info("get message : {}" , message);
    }
}
