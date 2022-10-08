package com.example.messagingrabbitmq.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    <T> Optional<T> findUserById(Long aLong, Class<T> type);

    <T> List<T> findUserByIdIn(List<Long> ids, Class<T> type);
}
