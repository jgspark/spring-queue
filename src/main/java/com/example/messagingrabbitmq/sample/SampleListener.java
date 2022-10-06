package com.example.messagingrabbitmq.sample;

import org.apache.logging.log4j.message.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SampleListener {

    @RabbitListener(queues = RabbitMaConfiguration.queueName)
    public void receiveMessage(final Message message) {
        System.out.println(message.toString());
    }
}
