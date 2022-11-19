package com.example.queue.repository;

import com.example.queue.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void create_success() {

        Order mock = Order.builder()
                .name("test")
                .build();

        Order entity = orderRepository.save(mock);

        assertNotNull(entity.getId());
        assertEquals(entity.getName(), mock.getName());
    }
}