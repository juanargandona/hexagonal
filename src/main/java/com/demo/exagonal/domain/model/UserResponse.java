package com.demo.exagonal.domain.model;

public record UserResponse(
        Long id,
        String firstname,
        String lastname) {
}
