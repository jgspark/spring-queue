package com.example.queue.util;

import com.example.queue.user.OnlyEmail;
import com.example.queue.user.User;

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
