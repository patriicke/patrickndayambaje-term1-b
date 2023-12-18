package com.example.simplecalculator.services;

import com.example.simplecalculator.exceptions.InvalidOperationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MathService {
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }
        return switch (operation) {
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            default -> throw new RuntimeException("Unknown operation");
        };
    }
}