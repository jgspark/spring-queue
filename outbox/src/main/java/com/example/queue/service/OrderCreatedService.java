package com.example.queue.service;

import com.example.queue.repository.OrderRepository;
import com.example.queue.service.dto.OrderCreatedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderCreatedService {

    private final OrderRepository orderRepository;

    @Transactional
    public Optional<OrderCreatedDTO.Response> created(OrderCreatedDTO.Request dto) {
        OrderCreatedDTO.Response data = new OrderCreatedDTO.Response(orderRepository.save(dto.toEntity()));
        return Optional.ofNullable(data);
    }
}
