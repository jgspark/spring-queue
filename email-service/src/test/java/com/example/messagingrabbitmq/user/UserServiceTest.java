package com.example.messagingrabbitmq.user;

import com.example.messagingrabbitmq.util.MockUtil;
import com.example.messagingrabbitmq.util.OnlyEmailTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    void getUserToOnlyEmail() {

        User mockUser = MockUtil.readJons("json/save.json", User.class);

        Optional<OnlyEmail> mock = Optional.of(new OnlyEmailTest(mockUser));

        given(userRepository.findUserById(any(), eq(OnlyEmail.class))).willReturn(mock);

        Optional<OnlyEmail> entity = userService.getUserToOnlyEmail(1L);

        then(userRepository).should().findUserById(any(), eq(OnlyEmail.class));

        assertEquals(entity.get().getEmail(), mock.get().getEmail());
    }
}