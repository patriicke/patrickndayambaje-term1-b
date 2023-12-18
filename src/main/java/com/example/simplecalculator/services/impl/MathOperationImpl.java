package com.example.simplecalculator.services.impl;

import com.example.simplecalculator.exceptions.InvalidOperationException;
import com.example.simplecalculator.services.MathOperation;
import org.springframework.stereotype.Service;

@Service
public class MathOperationImpl  implements MathOperation {
    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }

        return switch (operation) {
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            default -> throw new RuntimeException("Invalid operation");
        };
    }
}
