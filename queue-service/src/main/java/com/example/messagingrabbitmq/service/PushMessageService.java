package com.example.messagingrabbitmq.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.messagingrabbitmq.aws.TestQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PushMessageService {

    private final TestQueue queue;

    private final AmazonSQS amazonSQS;

    public SendMessageResult send(String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(queue.getUrl(), message);
        log.info("SendMessage: {}", message);
        return amazonSQS.sendMessage(sendMessageRequest);
    }
}
