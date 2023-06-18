package com.halvorot.demo.javaspringapplication.controller;

@RestController
public final class DemoController {

    private final DemoService demoService;

    public DemoController(final DemoService DemoService){
        this.demoService = demoService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getData() {
        return new ResponseEntity(HttpStatus.OK, "Demo data");
    }
}