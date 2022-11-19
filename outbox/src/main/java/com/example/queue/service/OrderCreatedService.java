package com.example.queue.service;

import com.example.queue.domain.Order;
import com.example.queue.repository.OrderRepository;
import com.example.queue.service.dto.OrderCreatedDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderCreatedService {

    private final OrderRepository orderRepository;

    @Transactional
    public OrderCreatedDTO.Response created(OrderCreatedDTO.Request dto) {
        Order entity = orderRepository.save(dto.toEntity());
        return new OrderCreatedDTO.Response(entity);
    }
}
