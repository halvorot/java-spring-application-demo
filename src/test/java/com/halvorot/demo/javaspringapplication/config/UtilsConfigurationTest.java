package com.halvorot.demo.javaspringapplication.config;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsConfigurationTest {

    @Test
    void should_return_nonnull_random() {

        // Arrange
        UtilsConfiguration utilsConfiguration = new UtilsConfiguration();

        // Act
        Random random = utilsConfiguration.random();

        // Assert
        assertThat(random).isNotNull();

    }
}