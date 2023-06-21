package com.halvorot.demo.javaspringapplication.controller;

import com.halvorot.demo.javaspringapplication.model.DemoObject;
import com.halvorot.demo.javaspringapplication.service.DemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService demoService;

    public DemoController(final DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/")
    public ResponseEntity<DemoObject> getData() {
        DemoObject demoObject = demoService.getDemoObject();
        return ResponseEntity.ok(demoObject);
    }

}
