package com.example.messagingrabbitmq.util;

import com.example.messagingrabbitmq.user.OnlyEmail;
import com.example.messagingrabbitmq.user.User;

public class OnlyEmailTest implements OnlyEmail {

    private final User user;

    public OnlyEmailTest(User user) {
        this.user = user;
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }
}
