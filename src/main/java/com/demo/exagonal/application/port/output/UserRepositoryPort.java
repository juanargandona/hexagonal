package com.demo.exagonal.application.port.output;

import com.demo.exagonal.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User create(User user);
    Optional<User> findById(Long id);
}
