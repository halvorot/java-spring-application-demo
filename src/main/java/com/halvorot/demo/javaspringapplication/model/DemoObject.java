package com.halvorot.demo.javaspringapplication.model;

import org.springframework.lang.NonNull;

public record DemoObject(@NonNull int id, @NonNull String name) {}
