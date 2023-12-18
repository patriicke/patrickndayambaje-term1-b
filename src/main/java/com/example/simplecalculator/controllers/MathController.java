package com.example.simplecalculator.controllers;

import com.example.simplecalculator.dtos.DoMathRequest;
import com.example.simplecalculator.exceptions.InvalidOperationException;
import com.example.simplecalculator.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/math")
public class MathController {
    @Autowired
    private MathService mathService;

    @PostMapping("/do-math")
    public ResponseEntity<Number> doMath(@RequestBody DoMathRequest dto) throws InvalidOperationException {
        Number result = mathService.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation());
        return ResponseEntity.ok(result);
    }
}