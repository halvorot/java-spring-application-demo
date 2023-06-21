package com.halvorot.demo.javaspringapplication.model;

import org.springframework.lang.NonNull;

public record DemoObject(int id, @NonNull String name) {}
