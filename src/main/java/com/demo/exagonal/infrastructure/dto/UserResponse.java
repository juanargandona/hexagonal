package com.demo.exagonal.infrastructure.dto;

public record UserResponse(
        Long id,
        String firstname,
        String lastname
) {
}
