package com.example.queue.web.rest;

import com.example.queue.service.publisher.SendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("send")
public class SendController {

    private final SendService sendService;

    @PostMapping
    public String send() throws Exception {
        sendService.sendQueue();
        return "success";
    }
}
