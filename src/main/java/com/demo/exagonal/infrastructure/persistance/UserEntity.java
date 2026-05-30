package com.demo.exagonal.infrastructure.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data

public class UserEntity {
    @Id
    @GeneratedValue
    private final Long id;
    private final String firstname;
    private final String lastname;

    public UserEntity(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserEntity() {
        this(null, null, null);
    }
}
