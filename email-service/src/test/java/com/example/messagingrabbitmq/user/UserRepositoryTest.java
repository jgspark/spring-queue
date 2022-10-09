package com.example.messagingrabbitmq.user;

import com.example.messagingrabbitmq.util.MockUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    @DisplayName("저장 테스트 케이스")
    void save() {

        User mock = MockUtil.readJons("json/save.json", User.class);

        User entity = userRepository.save(mock);

        assertNotNull(entity.getId());
        assertEquals(mock.getEmail(), entity.getEmail());
    }
}