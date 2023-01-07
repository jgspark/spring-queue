package com.example.queue.service.consumer;

import com.example.queue.base.CustomMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class ConsumerService {

//    @RabbitListener(queues = BaseRabbitMqInfo.queueName)
    public void receiveMessage(CustomMessage message) {
        log.info("get message : {}", message);
    }
}
