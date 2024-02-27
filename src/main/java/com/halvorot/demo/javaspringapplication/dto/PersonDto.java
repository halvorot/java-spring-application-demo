package com.halvorot.demo.javaspringapplication.dto;

import com.halvorot.demo.javaspringapplication.enums.Gender;

public record PersonDto(
    String ssn,
    String firstName,
    String lastName,
    Gender gender
) {
}