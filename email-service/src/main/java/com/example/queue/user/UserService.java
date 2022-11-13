package com.example.queue.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Optional<OnlyEmail> getUserToOnlyEmail(Long userId) {
        return userRepository.findUserById(userId, OnlyEmail.class);
    }

    @Transactional(readOnly = true)
    public List<OnlyEmail> getBulkUserToOnlyEmail(List<Long> userIds) {
        return userRepository.findUserByIdIn(userIds, OnlyEmail.class);
    }
}
