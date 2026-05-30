package com.demo.exagonal.application.port.input;

import com.demo.exagonal.domain.model.User;

public interface CreateUserPort {
    User createUser(User user);
}
