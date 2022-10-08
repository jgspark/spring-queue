package com.example.messagingrabbitmq.emailsend;

import com.example.messagingrabbitmq.emailsend.dto.EmailBulkSendDTO;
import com.example.messagingrabbitmq.user.OnlyEmail;
import com.example.messagingrabbitmq.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailSendService {
    private final RabbitTemplate rabbitTemplate;

    private final UserService userService;

    public void sendToEmailByUser(Long userId) {

        String email = userService.getUserToOnlyEmail(userId).map(OnlyEmail::getEmail).orElseThrow();

        sendToQueue(email);
    }

    public void sendToEmailsByUsers(EmailBulkSendDTO dto) {

        List<String> emails = userService.getBulkUserToOnlyEmail(dto.getUserIds()).stream().map(OnlyEmail::getEmail).toList();

        if (emails.isEmpty()) return;

        emails.forEach(this::sendToQueue);
    }

    private void sendToQueue(String email) {
        String routingKey = "email.service.user";
        rabbitTemplate.convertAndSend(EmailQueueInfo.topicExchangeName, routingKey, email);
    }
}
