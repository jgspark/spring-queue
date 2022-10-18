package com.example.messagingrabbitmq.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.messagingrabbitmq.aws.TestQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PushMessageService {

    private final TestQueue queue;

    private final AmazonSQS amazonSQS;

    public SendMessageResult send(String message) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(queue.getUrl(), message);
        return amazonSQS.sendMessage(sendMessageRequest);
    }
}
