package com.example.simplecalculator.services;

import com.example.simplecalculator.exceptions.InvalidOperationException;

public interface MathOperation {
    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
