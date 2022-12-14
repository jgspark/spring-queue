package com.example.queue.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitMqProperties {

    private String host;

    private Integer port;

    private String username;

    private String password;
}
