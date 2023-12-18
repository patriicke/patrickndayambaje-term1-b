package com.example.simplecalculator.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health-test")
public class HealthTest {
    @GetMapping()
    public ResponseEntity<String> healthTest() {
        return ResponseEntity.ok("Server is up and running!");
    }
}
