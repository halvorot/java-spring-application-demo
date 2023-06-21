package com.halvorot.demo.javaspringapplication.service;

import com.example.javaspringapplicationdemo.model.DemoObject;
import com.example.javaspringapplicationdemo.repository.DemoRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    private final DemoRepository demoRepository;

    public DemoService(final DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public DemoObject getDemoObject() {
        return demoRepository.findDemoObject();
    }

}
