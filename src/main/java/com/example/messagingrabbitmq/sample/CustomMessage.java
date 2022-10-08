package com.example.messagingrabbitmq.sample;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomMessage {
    private String text;
    private int index;

    public CustomMessage(String text, int index) {
        this.text = text;
        this.index = index;
    }
}
