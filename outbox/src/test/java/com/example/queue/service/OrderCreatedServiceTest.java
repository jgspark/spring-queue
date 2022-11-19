package com.example.queue.service;

import com.example.queue.domain.Order;
import com.example.queue.repository.OrderRepository;
import com.example.queue.service.dto.OrderCreatedDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class OrderCreatedServiceTest {

    @InjectMocks
    private OrderCreatedService orderCreatedService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeTestClass
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void create_ok() {

        final Long mockId = 1L;
        final String mockName = "test";
        Order mock = new Order(mockId, mockName);
        given(orderRepository.save(any())).willReturn(mock);

        OrderCreatedDTO.Request mockDTO = new OrderCreatedDTO.Request(mockName);
        OrderCreatedDTO.Response entity = orderCreatedService.created(mockDTO);

        then(orderRepository).should().save(any());
        assertEquals(mock.getName(), entity.getName());
    }
}