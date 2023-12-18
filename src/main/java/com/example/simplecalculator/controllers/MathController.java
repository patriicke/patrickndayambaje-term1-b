package com.example.simplecalculator.controllers;

import com.example.simplecalculator.dtos.DoMathRequest;
import com.example.simplecalculator.exceptions.InvalidOperationException;
import com.example.simplecalculator.services.impl.MathOperationImpl;
import com.example.simplecalculator.utils.CalcResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/math")
public class MathController {
    @Autowired
    private MathOperationImpl mathOperation;

    @PostMapping("/do-math")
    public ResponseEntity<CalcResponse> doMath(@RequestBody DoMathRequest dto) throws InvalidOperationException {
        try {
            double result = mathOperation.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation());
            return ResponseEntity.ok(new CalcResponse(result));
        } catch (InvalidOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CalcResponse(e.getMessage()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CalcResponse(e.getMessage()));
        }
    }
}
