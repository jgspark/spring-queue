package com.example.queue.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Table
@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
