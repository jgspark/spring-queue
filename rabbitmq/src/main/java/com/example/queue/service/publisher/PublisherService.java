package com.example.queue.service.publisher;

import com.example.queue.base.BaseRabbitMqInfo;
import com.example.queue.base.CustomMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;

import java.util.stream.IntStream;

@Slf4j
//@Service
@RequiredArgsConstructor
public class PublisherService implements CommandLineRunner {
    private static final String routingKey = "foo.bar.baz";

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) {
        log.info("send message.....");

        IntStream.range(0, 10).forEach(i -> {
            CustomMessage message = new CustomMessage("hello message : " + i, i);
            log.info("send message :{}", message);
            rabbitTemplate.convertAndSend(BaseRabbitMqInfo.topicExchangeName, routingKey, message);
        });
    }
}
