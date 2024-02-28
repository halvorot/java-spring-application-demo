package com.halvorot.demo.javaspringapplication.utils;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    void should_generate_random_string_when_length_is_positive() {

        // Arrange
        int length = 10;

        // Act
        String randomString = StringUtils.generateRandomString(length, new Random());

        // Assert
        assertThat(randomString)
            .hasSize(length)
            .matches("[a-z]{" + length + "}");

    }

    @Test
    void should_generate_empty_string_when_length_is_zero() {

        // Act
        String randomString = StringUtils.generateRandomString(0, new Random());

        // Assert
        assertThat(randomString)
            .isNotNull()
            .isEmpty();

    }
}