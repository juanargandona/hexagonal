package com.demo.exagonal.infrastructure.dto;

public record UserRequest(
        String firstname,
        String lastname
) {
}
