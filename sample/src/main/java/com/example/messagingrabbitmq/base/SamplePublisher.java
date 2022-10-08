package com.example.messagingrabbitmq.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Slf4j
@Component
public class SamplePublisher implements CommandLineRunner {
    private static final String routingKey = "foo.bar.baz";

    private final RabbitTemplate rabbitTemplate;

    public SamplePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        log.info("send message.....");

        IntStream.range(0, 10)
                .forEach(i -> {
                    CustomMessage message = new CustomMessage("hello message : " + i, i);
                    log.info("send message :{}", message);
                    rabbitTemplate.convertAndSend(BaseRabbitMqInfo.topicExchangeName, routingKey, message);
                });
    }
}
