package com.demo.exagonal.application.port.input;

import com.demo.exagonal.domain.model.User;

import java.util.Optional;

public interface GetUserPort {
    Optional<User> findUserById(Long id);
}
