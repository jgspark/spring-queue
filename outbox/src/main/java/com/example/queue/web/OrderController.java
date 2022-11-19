package com.example.queue.web;

import com.example.queue.service.OrderCreatedService;
import com.example.queue.service.dto.OrderCreatedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderCreatedService orderCreatedService;

    @PostMapping
    public ResponseEntity<OrderCreatedDTO.Response> created(OrderCreatedDTO.Request dto) {
        Optional<OrderCreatedDTO.Response> optional = orderCreatedService.created(dto);
        if (optional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(optional.get());
    }
}
