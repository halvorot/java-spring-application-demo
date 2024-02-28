package com.halvorot.demo.javaspringapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
public class UtilsConfiguration {

    @Bean
    public SecureRandom secureRandom() {
        return new SecureRandom();
    }

}
