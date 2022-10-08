package com.example.messagingrabbitmq.email;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailQueueInfo {

    public static final String queueName = "email-queue";
    public static final String topicExchangeName = "email-exchange";
    private static final String routingKey = "email.service.#";

    @Bean
    public Queue queue() {
        return new Queue(queueName , false);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}
