package com.example.queue.service.dto;

import com.example.queue.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class OrderCreatedDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String name;

        public Order toEntity() {
            return Order.createdBuilder().name(name).build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        private Long id;

        private String name;

        public Response(Order order) {
            this.id = order.getId();
            this.name = order.getName();
        }
    }
}
