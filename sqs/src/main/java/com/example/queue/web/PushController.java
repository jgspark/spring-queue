package com.example.queue.web;

import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.queue.service.PushMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sqs")
@RequiredArgsConstructor
public class PushController {

    private final PushMessageService service;

    @PostMapping
    public SendMessageResult sendMessage(@RequestBody Map<String, String> dto) {
        String msg = Optional.ofNullable(dto.get("msg")).map(v -> (String) v).orElseThrow();
        return service.send(msg);
    }
}
