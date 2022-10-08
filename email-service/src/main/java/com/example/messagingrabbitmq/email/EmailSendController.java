package com.example.messagingrabbitmq.email;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailSendController {

    private final EmailSendService emailSendService;

    @PostMapping
    public void sendToEmail(@RequestBody EmailSendDTO dto){
        emailSendService.sendToQueue(dto);
    }
}
