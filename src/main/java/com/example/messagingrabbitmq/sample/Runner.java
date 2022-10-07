package com.example.messagingrabbitmq.sample;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public Runner(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        System.out.println("Sending message...");
//        CustomMessage message = new CustomMessage("Hello Message!", 1, true);
//        rabbitTemplate.convertAndSend(RabbitMaConfiguration.topicExchangeName, "foo.bar.baz", message);
        rabbitTemplate.convertAndSend(RabbitMaConfiguration.topicExchangeName, "foo.bar.baz", "tester");
    }
}
