package com.example.queue.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Table
@Entity(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;

    @Builder(builderMethodName = "createdBuilder")
    private Order(String name) {
        this.name = name;
    }
}
