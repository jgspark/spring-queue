package com.example.queue.service.publisher;

import com.example.queue.base.BaseRabbitMqInfo;
import com.example.queue.base.CustomMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendService {

    private final RabbitTemplate rabbitTemplate;

    private final String key = "foo.bar.message";

    private int count = 0;

    public void sendQueue() throws Exception {
        var msg = new CustomMessage("여기 메시지 보내기", count++);
        rabbitTemplate.convertAndSend(BaseRabbitMqInfo.topicExchangeName, key, count++);
    }
}
