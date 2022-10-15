package com.example.messagingrabbitmq.emailsend;

import com.example.messagingrabbitmq.emailsend.dto.EmailBulkSendDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class EmailSendController {

    private final EmailSendService emailSendService;

    @PostMapping("{userId}/email")
    public void sendToEmail(@PathVariable Long userId) {
        emailSendService.sendToEmailByUser(userId);
    }

    @PostMapping("emails")
    public void sendToEmails(@RequestBody EmailBulkSendDTO dto) {
        emailSendService.sendToEmailsByUsers(dto);
    }
}
