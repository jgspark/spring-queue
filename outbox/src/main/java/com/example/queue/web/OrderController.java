package com.example.queue.web;

import com.example.queue.service.OrderCreatedService;
import com.example.queue.service.dto.OrderCreatedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderCreatedService orderCreatedService;

    @PostMapping
    public OrderCreatedDTO.Response created(@RequestBody OrderCreatedDTO.Request dto) {
        return orderCreatedService.created(dto);
    }
}
