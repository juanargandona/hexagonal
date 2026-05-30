package com.demo.exagonal.application.port.service;

import com.demo.exagonal.application.port.input.CreateUserPort;
import com.demo.exagonal.application.port.input.GetUserPort;
import com.demo.exagonal.application.port.output.UserRepositoryPort;
import com.demo.exagonal.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceUseCase implements CreateUserPort, GetUserPort {
    private final UserRepositoryPort userRepositoryPort;

    public UserServiceUseCase(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        return userRepositoryPort.create(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepositoryPort.findById(id);
    }
}
