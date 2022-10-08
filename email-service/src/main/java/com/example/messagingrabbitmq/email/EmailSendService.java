package com.example.messagingrabbitmq.email;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {
    private final RabbitTemplate rabbitTemplate;
    private final String routingKey = "email.service.user";

    public void sendToQueue(EmailSendDTO dto){
        rabbitTemplate.convertAndSend(EmailQueueInfo.topicExchangeName , routingKey ,dto);
    }
}
