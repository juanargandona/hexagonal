package com.demo.exagonal.domain.model;

public record User(
        Long id,
        String firstname,
        String lastname) {
}
