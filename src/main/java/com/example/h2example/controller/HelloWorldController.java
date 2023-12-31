package com.example.h2example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok().body("Hello World");
    }
}
