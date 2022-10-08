package com.example.messagingrabbitmq.base;

import com.example.messagingrabbitmq.config.RabbitMQTestConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        RabbitMQTestConfiguration.class
})
public class BaseRabbitMqInfoTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //    @Autowired
//    private RabbitAdmin admin;
//
    @Autowired
    private RabbitListenerEndpointRegistry registry;


    @Test
    @DisplayName("연결을 위한 테스트 케이스")
    void testConnection() {

//        CustomMessage message = new CustomMessage("test message", 0);
//
//        rabbitTemplate.convertAndSend(RabbitMQTestConfiguration.topicExchangeName, RabbitMQTestConfiguration.routingKey, message);

    }
}