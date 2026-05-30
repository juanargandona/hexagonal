package com.demo.exagonal.infrastructure.persistance;

import com.demo.exagonal.application.port.output.UserRepositoryPort;
import com.demo.exagonal.domain.model.User;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryJpaAdapter implements UserRepositoryPort {
    private final UserRepositoryJpa userRepositoryJpa;

    public UserRepositoryJpaAdapter(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public User create(User user) {
        UserEntity userEntity = new UserEntity(user.id(), user.firstname(), user.lastname());
        userRepositoryJpa.save(userEntity);
        return new User(userEntity.getId(), userEntity.getFirstname(), userEntity.getLastname());
    }

    @Override
    public Optional<User> findById(Long id) {
        final UserEntity userEntity = userRepositoryJpa.findById(id).orElseThrow(()->
                new IllegalArgumentException("User not found"));
        return Optional.of(new User(userEntity.getId(), userEntity.getFirstname(), userEntity.getLastname()));
    }
}
