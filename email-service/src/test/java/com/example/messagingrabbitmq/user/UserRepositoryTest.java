package com.example.messagingrabbitmq.user;

import com.example.messagingrabbitmq.util.MockUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Nested
    @DisplayName("조회 테스트 케이스")
    class Select {

        private User mock2;

        @BeforeEach
        void init() {

            User mock = MockUtil.readJons("json/save.json", User.class);

            mock2 = userRepository.save(mock);

            userRepository.flush();
        }

        @Test
        @DisplayName("유저 아이디 별로 조회 테스트 케이스")
        void findUserById() {

            OnlyEmail entity = userRepository.findUserById(mock2.getId(), OnlyEmail.class).orElseThrow();

            assertEquals(mock2.getEmail(), entity.getEmail());
        }

    }
}