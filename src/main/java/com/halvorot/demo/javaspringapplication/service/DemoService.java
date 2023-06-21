package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.model.DemoObject;
import com.halvorot.demo.javaspringapplication.repository.DemoRepository;
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
