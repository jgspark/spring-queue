package com.example.queue.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class GetMessageService {

    @SqsListener(value = "testQueue", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void getPushMessageListener(@Payload String message, @Header Map<String, String> headers) {
        log.info("Queue Message: {}", message);
        log.info("{}", headers);
    }
}
